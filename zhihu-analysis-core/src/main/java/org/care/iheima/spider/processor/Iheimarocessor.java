package org.care.iheima.spider.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * Created by van persie on 2017/2/17.
 */
public class Iheimarocessor implements PageProcessor {

    private Site site;

    @Override
    public void process(Page page) {
        Selectable title = page.getHtml().xpath("div[@class='title']/text()");
        Selectable date = page.getHtml().xpath("div[@class='author']/span/time/text()");
        Selectable content = page.getHtml().xpath("//div[@class='main-content']") //利用xpath取出核心内容
                .regex("<div class=\"main-content\">(.*)<div class=\"copyright\">") //利用正则更加准确的截取核心内容
                .replace("<(?!img|br|p|/p|strong|/strong|pre|/pre).*?>", "") //利用正则去掉Html标签，只保留<img><br><p></p><strong></strong>
                //了解正则表达式多行模式、单行模式的区别。(?m)开启多行模式
                .replace("(?m)^\\s*$(\\n|\\r\\n)", "");//利用正则去掉空行



        page.putField("title", title);
        page.putField("date", date);
        page.putField("content", content.toString());

    }

    @Override
    public Site getSite() {
        this.site = Site.me().setCycleRetryTimes(3).setRetryTimes(3).setSleepTime(1000).setTimeOut(3 * 60 * 1000)
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .setCharset("UTF-8");
        return this.site;
    }
}
