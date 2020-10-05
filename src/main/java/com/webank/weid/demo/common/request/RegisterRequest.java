package com.webank.weid.demo.common.request;

import lombok.Data;

/**
 * 用户登陆请求类
 *
 * @Author: ningque
 * @Date: 2020/10/5
 * @Version 1.0
 */
@Data
public class RegisterRequest {
    /**
     * 用户账户名
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;
}
