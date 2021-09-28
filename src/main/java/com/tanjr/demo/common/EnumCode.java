/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.tanjr.demo.common;

/**
 * 定义枚举常量，包括状态码和描述
 * @author tanjr
 */
public enum EnumCode {
    // 成功
    // 这里的代码相当于：public static  final DataEnumCode SUCCESS = new DataEnumCode(0,“ok”)调用类有参构造传值
    SUCCESS(200, "ok"),
    // 系统异常
    SYSTEM_ERROR(5001, "服务器系统异常，请稍后..."),
    // 参数异常
    PARAMETER_ERROR(5002, "参数异常，认证失败..."),
    // 用户名异常;注意上面的是逗号分隔，这里结束是分号
    USER_HAS_ERROR(5003, "用户名已存在....");

    // 状态码
    private final int code;
    // 描述
    private final String message;

    /**
     * 私有构造,防止被外部调用
     */
    EnumCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return 返回状态码
     */
    public int getCode() {
        return code;
    }

    /**
     * @return 返回描述
     */
    public String getMessage() {
        return message;
    }
}