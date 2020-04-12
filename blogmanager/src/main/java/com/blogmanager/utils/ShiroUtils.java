package com.blogmanager.utils;

import com.common.entity.User;
import com.common.utils.DBException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
    public static User getUser() {
        Object object = getSubjct().getPrincipal();
        return (User)object;
    }
    public static String getUserId() {
        return getUser().getUserId();
    }
    /**
     * 获取
     * @return
     */
    public static String getUserCode() {
    	try {
    		return getUser().getUserId();
		} catch (Exception e) {
			throw new DBException("获取用户登录异常");
		}
    }
    /**
     * 获取用户名称 如果为空 返回USERCODE
     * @return
     */
    public static String getUserName() {
    	return getUser().getUserName()==null?getUser().getUserId():getUser().getUserName();
    }

    /**
     * 退出登录
     */
    public static void logout() {
        getSubjct().logout();
    }
}
