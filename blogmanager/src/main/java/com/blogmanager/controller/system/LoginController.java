package com.blogmanager.controller.system;

import com.blogmanager.service.UserService;
import com.blogmanager.system.annotation.Log;
import com.blogmanager.utils.MD5Utils;
import com.blogmanager.utils.ShiroUtils;
import com.common.entity.User;
import com.common.model.enums.ResultEnum;
import com.common.model.vo.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    /**
     * 进入登录界面
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @Log("登录")
    @PostMapping("/login")
    @ResponseBody
    public Result ajaxLogin(String userId, String passWord) {
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(passWord)) {
            return new Result(ResultEnum.SERVER_ERROR.getCode(), "用户名和密码均不可为空");
        }
        passWord = MD5Utils.encrypt(userId, passWord);
        UsernamePasswordToken token = new UsernamePasswordToken(userId, passWord);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return new Result(ResultEnum.SUCESS);
        } catch (AuthenticationException e) {
            return new Result(ResultEnum.SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("/register");
    }

    @Log("注册用户")
    @PostMapping("/register")
    public Result registerUser(User user) {
        return this.userService.addUser(user);
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        ShiroUtils.logout();
        return "redirect:/login";
    }
}
