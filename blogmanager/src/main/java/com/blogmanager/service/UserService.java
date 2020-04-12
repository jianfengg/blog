package com.blogmanager.service;

import com.blogmanager.mapper.UserMapper;
import com.blogmanager.utils.MD5Utils;
import com.common.entity.User;
import com.common.model.enums.ResultEnum;
import com.common.model.vo.Result;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     * @param user
     * @return
     */
    public Result addUser(User user) {
        try {
            if(StringUtils.isBlank(user.getUserId())) {
                return new Result(ResultEnum.SERVER_ERROR.getCode(), "账号不可为空");
            }
            if(StringUtils.isBlank(user.getUserId())) {
                return new Result(ResultEnum.SERVER_ERROR.getCode(), "密码不可为空");
            }
            User userCount = userMapper.selectByPrimaryKey(user.getUserId());
            if(userCount != null && StringUtils.isNotBlank(userCount.getUserId())) {
                return new Result(ResultEnum.SERVER_ERROR.getCode(), "用户名已存在");
            }
            user.setPassWord(MD5Utils.encrypt(user.getUserId(), user.getPassWord()));
            user.setUserStatus(0);//用户状态设置0
            this.userMapper.insert(user);
        } catch (Exception e) {
            LOG.error("用户新增异常,{}", e.getMessage(), e);
            return new Result(ResultEnum.SERVER_ERROR);
        }
        return new Result(ResultEnum.SUCESS);
    }

}
