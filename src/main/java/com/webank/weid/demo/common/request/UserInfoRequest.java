package com.webank.weid.demo.common.request;

import lombok.Data;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
@Data
public class UserInfoRequest {
    /**
     * 电话号
     */
    private String phoneNumber;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 身份证号
     */
    private String identityNumber;

    /**
     * 性别
     */
    private String sex;
}
