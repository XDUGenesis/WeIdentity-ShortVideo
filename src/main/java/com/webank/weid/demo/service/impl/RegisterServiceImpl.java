package com.webank.weid.demo.service.impl;

import com.webank.weid.demo.common.dos.WeIdDo;
import com.webank.weid.demo.common.request.RegisterRequest;
import com.webank.weid.demo.mapper.UserAgentMapper;
import com.webank.weid.demo.service.RegisterService;
import com.webank.weid.protocol.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ningque
 * @Date: 2020/10/5
 * @Version 1.0
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserAgentMapper userAgentMapper;

    /**
     * 用户登陆
     * @param registerRequest 登陆请求
     * @return 返回登陆响应
     */
    @Override
    public ResponseData<Boolean> userRegister(RegisterRequest registerRequest) {
        ResponseData<Boolean> responseData = new ResponseData<>();
        String account = registerRequest.getAccount();
        WeIdDo weIdDo = userAgentMapper.findByAccount(account);
        if(weIdDo != null && weIdDo.getPassword().equals(registerRequest.getPassword())){
            responseData.setResult(true);
        } else {
            responseData.setResult(false);
        }
        return responseData;
    }
}
