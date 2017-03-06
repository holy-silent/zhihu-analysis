package org.care.spider.zhihu.entity;

import org.care.core.dao.base.BaseEntity;
import org.care.spider.zhihu.utils.IdGen;

/**
 * Created by van persie on 2017/3/2.
 */
public class UrlResult extends BaseEntity<UrlResult> {

    private String url;
    private String success;
    private String remarks;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public void preInsert() {
        this.id = IdGen.uuid();
    }

    @Override
    public void preUpdate() {

    }
}
