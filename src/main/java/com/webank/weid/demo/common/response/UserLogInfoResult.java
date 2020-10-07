package com.webank.weid.demo.common.response;

import lombok.Data;

import java.util.List;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
@Data
public class UserLogInfoResult {
    /**
     * 状态信息（success/fail)
     */
    private String msg;

    /**
     * 登陆日志信息
     */
    private List<LogInfo> logInfo;
}
