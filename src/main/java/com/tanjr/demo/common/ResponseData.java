/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.tanjr.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResponseData<T> {
    // 状态码
    private int code;

    // 提示消息
    private String message;

    // 响应结果集数据
    private T data;

    /**
     * 枚举类常量解析器
     * 快速解析枚举类常量信息，解析数据并放入到标准响应类ResponseData的属性中
     *
     * @param enumCode 枚举类常量
     */
    public void parserEnum(EnumCode enumCode) {
        this.code = enumCode.getCode();
        this.message = enumCode.getMessage();
    }

    /**
     * 定义请求成功的：状态码，描述，结果集数据
     *
     * @param data 传递的响应结果集数据
     * @return 有成功状态码，描述，结果集数据的标准格式对象
     */
    public static <T> ResponseData<T> success(T data) {
        // 创建响应标准格式对象,并设置结果数据
        ResponseData<T> responseData = new ResponseData<T>().setData(data);
        // 调用转换器方法，将（成功）枚举常量解析，放入到标准响应数据中。
        responseData.parserEnum(EnumCode.SUCCESS);
        return responseData;
    }

    /**
     * 定义请求失败的：
     *
     * @param enumCode 失败时传递的常见错误枚举常量
     * @return 有失败状态码，描述，结果集可为null，也可为自定义异常信息
     */
    public static <T> ResponseData<T> error(EnumCode enumCode, T data) {
        // 创建响应标准格式对象
        ResponseData<T> responseData = new ResponseData<T>().setData(data);
        // 调用转换器方法，将（错误）枚举常量解析。
        responseData.parserEnum(enumCode);
        return responseData;
    }

    /**
     * 有成功，有失败，但是失败的状态描述不一定能全部满足需求（枚举类有限），所以，自定义方法实现自定义信息
     *
     * @param code 自定义的状态码
     * @param message 自定义的错误信息
     * @return 有失败自定义状态码，自定义描述，结果集可为null，也可为自定义异常信息
     */
    public static <T> ResponseData<T> generator(int code, String message, T data) {
        // 创建响应标准格式对象
        return new ResponseData<T>().setCode(code).setMessage(message).setData(data);
    }

}
