package org.care.zhihu.spider.main;

import org.care.zhihu.spider.entity.UserEntity;
import org.care.zhihu.spider.pipeline.UserPipeline;
import org.care.zhihu.spider.processor.UserProcessor;
import org.care.zhihu.spider.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * 爬虫启动类
 * 知乎用户分析：
 * 1、分析性别比例
 * 2、分析工作地点比例
 * 3、分析所在公司比例
 * 4、分析活跃程度
 * 5、分析知乎用户中的美女图片【涉及到神经网络算法的应用】
 *
 *
 *
 * Created by van persie on 2017/2/15.
 */
public class Startup {
    static public void main(String[] args) {
        //加载spring
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserProcessor p = new UserProcessor();
        p.setStartUrl("https://www.zhihu.com/people/kaifulee");

        Spider.create(p).addUrl(p.getStartUrl())
//                .setScheduler(new FileCacheQueueScheduler("D:\\webmagic\\").setDuplicateRemover(new BloomFilterDuplicateRemover(5000)))
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(5000)))
//                .addPipeline(new FilePipeline("D:\\webmagic\\"))
                .addPipeline(new UserPipeline(context))
                .thread(1)
                .run();
    }
}
