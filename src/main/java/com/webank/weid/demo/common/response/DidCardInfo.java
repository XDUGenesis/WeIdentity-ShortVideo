package com.webank.weid.demo.common.response;

import lombok.Data;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
@Data
public class DidCardInfo {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 身份证
     */
    private String identityNumber;

    /**
     * DID
     */
    private String publicKey;

    /**
     * 是否在防沉迷状态
     */
    private  boolean antiAddiction;

    /**
     * 青少年模式
     */
    private  boolean youthMode;
}
