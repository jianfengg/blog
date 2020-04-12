package com.common.model.enums;

/**
 * 返回常用量枚举
 */
public enum ResultEnum {

    SUCESS(200, "操作成功"),
    SERVER_ERROR(506, "服务器异常");
    ResultEnum(final int code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
