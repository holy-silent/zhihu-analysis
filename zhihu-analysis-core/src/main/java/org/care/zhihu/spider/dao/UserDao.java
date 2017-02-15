package org.care.zhihu.spider.dao;

import org.care.zhihu.spider.dao.base.CrudDao;
import org.care.zhihu.spider.dao.base.MyBatisDao;
import org.care.zhihu.spider.entity.UserEntity;

/**
 * Created by van persie on 2017/2/15.
 */
@MyBatisDao
public interface UserDao extends CrudDao<UserEntity>{
}
