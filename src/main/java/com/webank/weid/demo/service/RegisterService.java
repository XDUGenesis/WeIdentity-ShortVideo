package com.webank.weid.demo.service;

import com.webank.weid.demo.common.request.RegisterRequest;
import com.webank.weid.protocol.response.ResponseData;

/**
 * @Author: ningque
 * @Date: 2020/10/5
 * @Version 1.0
 */
public interface RegisterService {
    /**
     * 用户登陆服务
     *
     * @param registerRequest 登陆请求
     * @return 响应
     */
    ResponseData<Boolean> userRegister(RegisterRequest registerRequest);
}
