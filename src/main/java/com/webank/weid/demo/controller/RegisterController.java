package com.webank.weid.demo.controller;

import com.webank.weid.demo.common.request.RegisterRequest;
import com.webank.weid.demo.service.RegisterService;
import com.webank.weid.protocol.response.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆控制类
 *
 * @Author: ningque
 * @Date: 2020/10/5
 * @Version 1.0
 */
@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @ApiOperation(value = "用户登陆")
    @PostMapping("/shortVideo/register")
    public ResponseData userRegister(RegisterRequest registerRequest){
        return registerService.userRegister(registerRequest);
    }
}
