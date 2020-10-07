package com.webank.weid.demo.service.impl;

import com.webank.weid.demo.common.dos.WeIdDo;
import com.webank.weid.demo.common.request.RegisterRequest;
import com.webank.weid.demo.common.response.ResMsg;
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
    public ResponseData<ResMsg> userRegister(RegisterRequest registerRequest) {
        ResponseData<ResMsg> responseData = new ResponseData<>();
        ResMsg msg = new ResMsg();
        String account = registerRequest.getPhoneNumber();
        WeIdDo weIdDo = userAgentMapper.findByAccount(account);
        if(weIdDo != null && weIdDo.getPassword().equals(registerRequest.getPassword())){
            msg.setMsg("success");
        } else {
            msg.setMsg("fail");
        }
        responseData.setResult(msg);
        return responseData;
    }
}
