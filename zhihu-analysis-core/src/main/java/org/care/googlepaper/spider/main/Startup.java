package org.care.googlepaper.spider.main;

import org.care.googlepaper.spider.processor.PaperProcessor;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * download google paper
 * Created by van persie on 2017/2/17.
 */
public class Startup {
    public static void main(String[] args) {

        PaperProcessor p = new PaperProcessor();

        Spider.create(p).addUrl("https://research.google.com/pubs/BrainTeam.html")
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(5000)))
                .addPipeline(new FilePipeline("D:\\webmagic\\"))
                .thread(1)
                .run();
    }
}
