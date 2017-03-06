package org.care.spider.zhihu.service;

import org.care.core.service.base.CrudService;
import org.care.spider.zhihu.dao.UserDao;
import org.care.spider.zhihu.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * Created by van persie on 2017/2/15.
 */
@Service
public class UserService extends CrudService<UserDao, UserEntity> {
}
