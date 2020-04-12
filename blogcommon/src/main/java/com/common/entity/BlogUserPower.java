package com.common.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户权限表
 */
public class BlogUserPower implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//标识，从1自动增长
	private Long id;
	//用户账号，ESMS_USER.id
	private String userId;
	//权限值，由系统枚举定义
	private String powerValue;
	//创建日期，自动取创建的当前日期
	private Date createTime;
	//创建人
	private String createUser;
	//最后修改时间
	private Date updateTime;
	//最后修改人
	private String updateUser;

	/**
	 * 设置：标识，从1自动增长
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：标识，从1自动增长
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户账号，ESMS_USER.id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户账号，ESMS_USER.id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：权限值，由系统枚举定义
	 */
	public void setPowerValue(String powerValue) {
		this.powerValue = powerValue;
	}
	/**
	 * 获取：权限值，由系统枚举定义
	 */
	public String getPowerValue() {
		return powerValue;
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
}
