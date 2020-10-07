package com.webank.weid.demo.common.response;

import lombok.Data;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
@Data
public class UserInfoResult {
    /**
     * 状态（success/fail）
     */
    private String msg;

    /**
     * 用户信息
     */
    private DidCardInfo didcardinfo;
}
