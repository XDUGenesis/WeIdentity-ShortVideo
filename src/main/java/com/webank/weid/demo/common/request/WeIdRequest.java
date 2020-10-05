package com.webank.weid.demo.common.request;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 创建WeId请求类
 *
 * @Author: zxh
 * @Date: 2020/10/4
 * @Version 1.0
 */
@Data
public class WeIdRequest {
    /**
     * 用户DID
     */
    private String did;

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;
}
