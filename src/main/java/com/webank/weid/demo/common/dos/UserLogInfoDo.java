package com.webank.weid.demo.common.dos;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
@Data
public class UserLogInfoDo {
    /**
     * DID
     */
    private String DID;

    /**
     * ip
     */
    private String ipAddress;

    /**
     * 登陆地址
     */
    private String loginAddress;

    /**
     * 登陆时间
     */
    private Timestamp createTime;
}
