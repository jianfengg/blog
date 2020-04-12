package com.blogmanager.system.config.shiro;


import com.blogmanager.system.config.ApplicationContextRegister;
import com.blogmanager.mapper.UserMapper;
import com.blogmanager.service.BlogUserPowerService;
import com.blogmanager.utils.MD5Utils;
import com.blogmanager.utils.ShiroUtils;
import com.common.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.List;

/**
 * 用户验证
 */
public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		String userId = ShiroUtils.getUserCode();
		BlogUserPowerService powerService = ApplicationContextRegister.getBean(BlogUserPowerService.class);
		List<String> powers = powerService.listPowers(userId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(new HashSet<>(powers));
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());

		UserMapper userMapper = ApplicationContextRegister.getBean(UserMapper.class);
		// 查询用户信息
		User user = userMapper.selectByPrimaryKey(username);
		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		// 密码错误
		if (!password.equals(user.getPassWord())) {//正常登录
			if(!password.equals(MD5Utils.encrypt(username, MD5Utils.BASE_PWD))){
				throw new IncorrectCredentialsException("账号或密码不正确");
			}
		}
		// 账号锁定
		if (user.getUserStatus() == 1) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
