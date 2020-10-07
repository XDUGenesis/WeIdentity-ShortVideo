package com.webank.weid.demo.service;

import com.webank.weid.demo.common.dos.WeIdDo;
import com.webank.weid.demo.common.request.UserInfoRequest;
import com.webank.weid.demo.common.response.UserLogInfoResult;
import com.webank.weid.protocol.response.ResponseData;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
public interface UserLogService {

    /**
     * 插入日志记录
     * @param WeIdDo DID参数
     * @return 成功与否
     */
    boolean insertLogInfo(WeIdDo WeIdDo);

    /**
     * 获取用户登陆日志
     * @param userInfoRequest 请求（电话号）
     * @return 响应（日志记录）
     */
    ResponseData<UserLogInfoResult> recentLog(UserInfoRequest userInfoRequest);
}
