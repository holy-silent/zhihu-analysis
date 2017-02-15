package org.care.zhihu.spider.service;

import org.care.zhihu.spider.dao.UserDao;
import org.care.zhihu.spider.entity.UserEntity;
import org.care.zhihu.spider.service.base.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by van persie on 2017/2/15.
 */
@Service
public class UserService extends CrudService<UserDao, UserEntity> {
}
