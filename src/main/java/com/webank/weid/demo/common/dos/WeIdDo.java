package com.webank.weid.demo.common.dos;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author: ningque
 * @Date: 2020/10/4
 * @Version 1.0
 */
@Data
public class WeIdDo {
    /**
     * 用户DID
     */
    private String did;
    /**
     * 年龄
     */
    private int age;
    /**
     * 手机号
     */
    private String number;
    /**
     * 性别
     */
    private String sex;
    /**
     * 信用值
     */
    private String idCard;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp updateTime;
}
