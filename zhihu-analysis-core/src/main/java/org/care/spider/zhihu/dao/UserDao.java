package org.care.spider.zhihu.dao;

import org.care.core.dao.base.CrudDao;
import org.care.core.dao.base.MyBatisDao;
import org.care.spider.zhihu.entity.UserEntity;

/**
 * Created by van persie on 2017/2/15.
 */
@MyBatisDao
public interface UserDao extends CrudDao<UserEntity> {
}
