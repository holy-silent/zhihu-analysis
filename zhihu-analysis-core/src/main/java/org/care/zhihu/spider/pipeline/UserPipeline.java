package org.care.zhihu.spider.pipeline;

import org.care.utils.SpringContextUtils;
import org.care.zhihu.spider.entity.UserEntity;
import org.care.zhihu.spider.service.UserService;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by van persie on 2017/2/15.
 */
public class UserPipeline implements Pipeline{

    @Override
    public void process(ResultItems resultItems, Task task) {

        UserService userService = SpringContextUtils.getBean(UserService.class);

        UserEntity user = (UserEntity)resultItems.get("user");

        if (user == null) {
            return;
        }

        userService.save(user);
    }
}
