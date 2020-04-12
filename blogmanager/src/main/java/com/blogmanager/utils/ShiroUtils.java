package com.blogmanager.utils;

import com.blogmanager.model.pojo.UserDO;
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
    public static UserDO getUser() {
        Object object = getSubjct().getPrincipal();
        return (UserDO)object;
    }
    public static Long getUserId() {
        return getUser().getId();
    }
    /**
     * 获取：帐号，SIH用户中心账号，或注册账号，唯一性验证
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
    public static void logout() {
        getSubjct().logout();
    }

    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }
}
