package com.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String userId;

    private String userName;

    private String userMail;

    private String userPhone;

    private Integer userStatus;

    private String passWord;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;
}