package com.blogmanager.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 用户表
 * 
 * @author WangL
 * @email wangluochougui@163.com
 * @date 2019-11-09 08:19:08
 */
public class UserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//关键字，自增长
	private Long id;
	//帐号，SIH用户中心账号，或注册账号，唯一性验证
	private String userId;
	//邮箱，可自动从用户中心提取
	private String userMail;
	//姓名，可自动从用户中心提取
	private String userName;
	//电话，可自动从从用户中心提取
	private String userPhone;
	//状态，0-启用，1-停用
	private Integer userStatus;
	//用户类型，0-个人用户，1-企业用户
	private Integer userType;
	//证件号码
	private String userCard;
	//用户密码，保留，通过用户中心验证登录
	@JsonIgnore
	private String passWord;
	//创建日期，自动取创建的当前日期
	private Date createTime;
	//创建人
	private String createUser;
	//最后修改时间
	private Date updateTime;
	//最后修改人
	private String updateUser;
	
	private List<String> powers;

	/**
	 * 设置：关键字，自增长
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：关键字，自增长
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：帐号，SIH用户中心账号，或注册账号，唯一性验证
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：帐号，SIH用户中心账号，或注册账号，唯一性验证
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：邮箱，可自动从用户中心提取
	 */
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	/**
	 * 获取：邮箱，可自动从用户中心提取
	 */
	public String getUserMail() {
		return userMail;
	}
	/**
	 * 设置：姓名，可自动从用户中心提取
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：姓名，可自动从用户中心提取
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：电话，可自动从从用户中心提取
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 * 获取：电话，可自动从从用户中心提取
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 * 设置：状态，0-启用未验证金格，1-停用, 2-金格已验证
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * 获取：状态，0-启用未验证金格，1-停用, 2-金格已验证
	 */
	public Integer getUserStatus() {
		return userStatus;
	}
	/**
	 * 设置：用户类型，0-个人用户，1-企业用户
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	/**
	 * 获取：用户类型，0-个人用户，1-企业用户
	 */
	public Integer getUserType() {
		return userType;
	}
	/**
	 * 设置：用户密码，保留，通过用户中心验证登录
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**
	 * 获取：用户密码，保留，通过用户中心验证登录
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * 设置：创建日期，自动取创建的当前日期
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建日期，自动取创建的当前日期
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：最后修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：最后修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：最后修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：最后修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 获取:用户权限
	 * @return
	 */
	public List<String> getPowers() {
		return powers;
	}
	/**
	 * 设置:用户权限
	 * @param powers
	 */
	public void setPowers(List<String> powers) {
		this.powers = powers;
	}
	/**
	 * 获取:用户证件号
	 * @return
	 */
	public String getUserCard() {
		return userCard;
	}
	/**
	 * 设置:用户证件号
	 * @param userCard
	 */
	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}
	
}
