package com.webank.weid.demo.service;

import com.webank.weid.demo.common.request.RegisterRequest;
import com.webank.weid.demo.common.request.UserInfoRequest;
import com.webank.weid.demo.common.response.ResMsg;
import com.webank.weid.protocol.response.ResponseData;

/**
 * @Author: ningque
 * @Date: 2020/10/5
 * @Version 1.0
 */
public interface UserService {
    /**
     * 用户登陆服务
     *
     * @param registerRequest 登陆请求
     * @return 响应
     */
    ResponseData<ResMsg> userRegister(RegisterRequest registerRequest);

    /**
     * 用户信息完善
     * @param userInfoRequest 用户信息
     * @return 响应
     */
    ResponseData<ResMsg> completeUserInfo(UserInfoRequest userInfoRequest);
}
