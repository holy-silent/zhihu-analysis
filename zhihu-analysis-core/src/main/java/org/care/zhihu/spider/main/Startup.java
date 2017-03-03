package org.care.zhihu.spider.main;

import org.care.utils.SpringContextUtils;
import org.care.zhihu.spider.entity.UserEntity;
import org.care.zhihu.spider.listener.ZhihuSpiderListener;
import org.care.zhihu.spider.pipeline.UserPipeline;
import org.care.zhihu.spider.processor.UserProcessor;
import org.care.zhihu.spider.scheduler.EasyRedisScheduler;
import org.care.zhihu.spider.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.SpiderListener;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import javax.management.JMException;
import java.util.ArrayList;
import java.util.List;

/**
 * 爬虫启动类
 * 知乎用户分析：
 * 1、分析性别比例
 * 2、分析工作地点比例
 * 3、分析所在公司比例
 * 4、分析活跃程度
 * 5、分析知乎用户中的美女图片【涉及到神经网络算法的应用】
 *
 * 路人甲是个爬虫高手，可参考他的想法学习。
 * 路人甲：https://www.zhihu.com/question/36132174/answer/145997723
 *
 * 在哪里能找到各行业的分析研究报告?  该帖子所罗列的网址，也有许多值得学习的经验
 * https://www.zhihu.com/question/19766160
 *
 * Created by van persie on 2017/2/15.
 */
public class Startup {
    static public void main(String[] args) {
        //加载spring
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SpringContextUtils.setApplicationContext(context);

        UserProcessor p = new UserProcessor();
//        p.setStartUrl("https://www.zhihu.com/people/kaifulee");
        p.setStartUrl("https://www.zhihu.com/people/kafka0102");

        List<SpiderListener> listSpiderListener = new ArrayList<SpiderListener>();
        listSpiderListener.add(new ZhihuSpiderListener());
        Spider zhihuSpider = Spider.create(p).addUrl(p.getStartUrl())
//                .setScheduler(new FileCacheQueueScheduler("D:\\webmagic\\").setDuplicateRemover(new BloomFilterDuplicateRemover(5000)))
//                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(5000)))
//                .addPipeline(new FilePipeline("D:\\webmagic\\"))
                .setSpiderListeners(listSpiderListener)
                .setScheduler(new EasyRedisScheduler("127.0.0.1", 6379))
                .addPipeline(new UserPipeline())
                .thread(2);
        try {
            SpiderMonitor.instance().register(zhihuSpider);
        } catch (JMException e) {
            e.printStackTrace();
        }
        zhihuSpider.start();
    }
}
