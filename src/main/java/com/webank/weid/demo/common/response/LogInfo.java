package com.webank.weid.demo.common.response;

import lombok.Data;

import java.util.Date;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
@Data
public class LogInfo {
    /**
     * 姓名
     */
    private String name;

    /**
     * 登陆时间
     */
    private Date date;

    /**
     * 登陆地址
     */
    private String loginAddress;

    /**
     * 登陆IP
     */
    private String ipAddress;
}
