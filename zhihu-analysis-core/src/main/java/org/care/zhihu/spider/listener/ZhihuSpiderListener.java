package org.care.zhihu.spider.listener;

import org.care.utils.SpringContextUtils;
import org.care.zhihu.spider.entity.UrlResult;
import org.care.zhihu.spider.service.UrlResultService;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.SpiderListener;

/**
 * 记录下载成功与失败的url，记录下载失败url详细信息
 * Created by van persie on 2017/3/2.
 */
public class ZhihuSpiderListener implements SpiderListener{

    private UrlResultService urlResultService = SpringContextUtils.getBean(UrlResultService.class);

    @Override
    public void onSuccess(Request request) {
        UrlResult url = new UrlResult();
        url.setUrl(request.getUrl());
        url.setSuccess("0");
        urlResultService.save(url);
    }

    @Override
    public void onError(Request request) {
        UrlResult url = new UrlResult();
        url.setSuccess("1");
        url.setUrl(request.getUrl());
        url.setRemarks(request.toString());
        urlResultService.save(url);
    }
}
