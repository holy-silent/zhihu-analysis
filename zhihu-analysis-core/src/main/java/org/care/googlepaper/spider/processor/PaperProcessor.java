package org.care.googlepaper.spider.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by van persie on 2017/2/17.
 */
public class PaperProcessor implements PageProcessor {

    private Site site;

    @Override
    public void process(Page page) {

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
