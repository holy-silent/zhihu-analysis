package org.care.spider.iheima.main;

import org.care.spider.iheima.processor.Iheimarocessor;
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
