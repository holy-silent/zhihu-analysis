package org.care.zhihu.spider.processor;

import org.apache.commons.lang.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by van persie on 2017/2/14.
 */
public class UserProcessor implements PageProcessor {

    private String startUrl;

    private String FOLLOWING_LIST = "https://www\\.zhihu\\.com/people/.*/following";

    private String FOLLOWERS_LIST = "https://www\\.zhihu\\.com/people/.*/followers";

    private String USER_HREF = "https://www\\.zhihu\\.com/people/.*";

    private Site site = Site.me().setCycleRetryTimes(3).setSleepTime(1000).setTimeOut(3 * 60 * 1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .setCharset("UTF-8");

    @Override
    public void process(Page page) {
        String followingUrl = page.getHtml().xpath("//div[@class='Card FollowshipCard']/div/a[1]/@href").get();
        String followerUrl = page.getHtml().xpath("//div[@class='Card FollowshipCard']/div/a[2]/@href").get();

        page.addTargetRequest(followerUrl);
        page.addTargetRequest(followingUrl);

        if (page.getUrl().regex(FOLLOWING_LIST).match() || page.getUrl().regex(FOLLOWERS_LIST).match()) {
            page.addTargetRequests(page.getHtml().xpath("//div[@class='Profile-mainColumn']/div[@class='Card ProfileMain']/div[@class='List']").links().regex(USER_HREF).all());

            //TODO 将其他分页的链接抓取下来


        } else {
            Selectable userName = page.getHtml().xpath("//div[@class='ProfileHeader-contentHead']/h1/span[@class='ProfileHeader-name']/text()");
            Selectable userImage = page.getHtml().xpath("//div[@class='UserAvatar ProfileHeader-avatar']/img/@src");
            Selectable selfIntroduction = page.getHtml().xpath("//div[@class='ProfileHeader-contentHead']/h1/span[@class='RichText ProfileHeader-headline']/text()");
            Selectable homePage = page.getUrl();
            Selectable following = page.getHtml().xpath("//div[@class='NumberBoard FollowshipCard-counts']/a[1]/div[@class='NumberBoard-value']/text()");
            Selectable follower = page.getHtml().xpath("//div[@class='NumberBoard FollowshipCard-counts']/a[2]/div[@class='NumberBoard-value']/text()");

            String lives = null;
            String followingTopics = null;
            String followingColumn = null;
            String followingQuestions = null;
            String followingCollections = null;

            List<String> lightItem = page.getHtml().xpath("//div[@class='Profile-lightList']/a[@class='Profile-lightItem']").all();
            for (String s : lightItem) {
                if (StringUtils.isNotBlank(s)) {
                    List<String> span = new Html(s).xpath("//a/span/text()").all();
                    if (span==null || span.size()!=2) {
                        continue;
                    }
                    String key = span.get(0);
                    String value = span.get(1);

                    if (key==null || value==null) {
                        continue;
                    }

                    if (key.startsWith("举办过的")) {
                        lives = value;
                    } else if (key.startsWith("关注的话题")) {
                        followingTopics = value;
                    } else if (key.startsWith("关注的专栏")) {
                        followingColumn = value;
                    } else if (key.startsWith("关注的问题")) {
                        followingQuestions = value;
                    } else if (key.startsWith("关注的收藏夹")) {
                        followingCollections = value;
                    }
                }
            }

            String certificationInfo = null;
            String zhihuCollection = null;
            String getThanks = null;
            String getCollections = null;
            // TODO 利用正则表达式提取字符串
            List<String> card = page.getHtml().xpath("//div[@class='Profile-sideColumnItems']/div[@class='Profile-sideColumnItem']").all();
            for (String s : card) {
                if (StringUtils.isNotBlank(s)) {
                    if (s.indexOf("认证信息")>0) {
//                        Pattern pattern = Pattern.compile("参与\\s*(\\d*)\\s*次公共编辑");
//                        Matcher matcher = pattern.matcher(s);
                        certificationInfo = new Html(s).xpath("//div[@class='Profile-sideColumnItemValue']/text()").toString();
                    } else if (s.indexOf("知乎收录") > 0) {
                        Pattern pattern = Pattern.compile("知乎收录\\s*(\\d*)\\s*个回答");
                        Matcher matcher = pattern.matcher(s);
                        if (matcher.find()) {
                            zhihuCollection = matcher.group(1);
                        }
                    } else if (s.indexOf("次感谢") > 0 || s.indexOf("次收藏") > 0) {
                        Pattern pattern = Pattern.compile("获得\\s*(\\d*)\\s*次感谢");
                        Matcher matcher = pattern.matcher(s);
                        if (matcher.find()) {
                            getThanks = matcher.group(1);
                        }

                        pattern = Pattern.compile("\\s*(\\d*)\\s*次收藏");
                        matcher = pattern.matcher(s);
                        if (matcher.find()) {
                            getCollections = matcher.group(1);
                        }
                    }
                }
            }
            //TODO 个人信息区域数据   数据来源:页面上由ajax发送请求，请求格式为protobuf
            //获取性别信息
            String profileHeader = page.getHtml().xpath("//div[@class='ProfileHeader-info']").toString();
            String sex = null;
            if(StringUtils.isNotBlank(profileHeader)) {
                if (profileHeader.indexOf("Icon Icon--female") > 0) {
                    sex = "0";
                } else if (profileHeader.indexOf("Icon Icon--male") > 0) {
                    sex = "1";
                }
            }


            if (StringUtils.isBlank(userName.toString())) { //如果取不到用户名称则跳过下载过程
                page.setSkip(true);
            } else {
                page.putField("userName", userName);
                page.putField("userImage", userImage);
                page.putField("selfIntroduction", selfIntroduction);
                page.putField("homePage", homePage);
                page.putField("following", following);
                page.putField("follower", follower);
                page.putField("lives", lives);
                page.putField("followingTopics", followingTopics);
                page.putField("followingColumn", followingColumn);
                page.putField("followingQuestions", followingQuestions);
                page.putField("followingCollections", followingCollections);
                page.putField("certificationInfo", followingCollections);
                page.putField("zhihuCollection", followingCollections);
                page.putField("getThanks", followingCollections);
                page.putField("getCollections", followingCollections);
                page.putField("sex", sex);

            }
        }
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }

}
