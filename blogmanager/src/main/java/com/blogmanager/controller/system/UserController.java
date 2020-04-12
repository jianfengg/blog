package com.blogmanager.controller.system;

import com.blogmanager.service.UserService;
import com.blogmanager.utils.MD5Utils;
import com.common.entity.User;
import com.common.model.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户操作Controller
 */
@RequestMapping("/sys/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result addUser(User user) {
        return userService.addUser(user);
    }

}
