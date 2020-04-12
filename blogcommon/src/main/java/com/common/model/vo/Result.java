package com.common.model.vo;

import com.common.model.enums.ResultEnum;
import lombok.Data;

/**
 * 后台处理基本的返回值
 */
@Data
public class Result {

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getDesc();
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /** 状态码 */
    private int code;

    /**  回执消息 */
    private String msg;

}
