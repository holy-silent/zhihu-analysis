package org.care.iheima.spider.main;

import org.care.iheima.spider.processor.Iheimarocessor;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;

/**
 * Created by van persie on 2017/2/20.
 */
public class Startup {
    static public void main(String[] args) {
        Iheimarocessor p = new Iheimarocessor();

        Spider.create(p).addUrl("http://www.iheima.com/news/2017/0127/161019.shtml")
                .addPipeline(new ConsolePipeline())
                .addPipeline(new FilePipeline("D://webmagic//"))
                .thread(1)
                .run();
    }
}
