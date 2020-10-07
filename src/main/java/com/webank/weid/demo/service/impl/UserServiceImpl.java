package com.webank.weid.demo.service.impl;

import com.webank.weid.demo.common.dos.UserInfoDo;
import com.webank.weid.demo.common.dos.WeIdDo;
import com.webank.weid.demo.common.request.RegisterRequest;
import com.webank.weid.demo.common.request.UserInfoRequest;
import com.webank.weid.demo.common.response.DidCardInfo;
import com.webank.weid.demo.common.response.ResMsg;
import com.webank.weid.demo.common.response.UserInfoResult;
import com.webank.weid.demo.common.util.ConvertUtil;
import com.webank.weid.demo.mapper.UserAgentMapper;
import com.webank.weid.demo.mapper.UserInfoMapper;
import com.webank.weid.demo.service.UserService;
import com.webank.weid.protocol.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ningque
 * @Date: 2020/10/5
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserAgentMapper userAgentMapper;

    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    private UserInfoMapper userInfoMapper;

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

    /**
     * 用户信息完善
     *
     * @param userInfoRequest 用户信息
     * @return 响应
     */
    @Override
    public ResponseData<ResMsg> completeUserInfo(UserInfoRequest userInfoRequest) {
        ResponseData<ResMsg> responseData = new ResponseData<>();
        ResMsg msg = new ResMsg();
        String account = userInfoRequest.getPhoneNumber();
        UserInfoDo userInfo = new UserInfoDo();
        WeIdDo weIdDo = userAgentMapper.findByAccount(account);
        if(weIdDo != null){
            userInfo = convertUtil.convertToUserInfoDo(userInfoRequest);
            userInfo.setDid(weIdDo.getDid());
        }
        int ans = userInfoMapper.insertUserInfo(userInfo);
        if(ans == 1){
            msg.setMsg("success");
        } else {
            msg.setMsg("fail");
        }
        responseData.setResult(msg);
        return responseData;
    }

    /**
     * 获取用户卡片信息
     *
     * @param userInfoRequest 请求体（电话号）
     * @return 响应（信息）
     */
    @Override
    public ResponseData<UserInfoResult> didCardInfo(UserInfoRequest userInfoRequest) {
        ResponseData<UserInfoResult> responseData = new ResponseData<>();
        UserInfoResult userInfoResult = new UserInfoResult();
        DidCardInfo cardInfo = new DidCardInfo();
        String account = userInfoRequest.getPhoneNumber();
        UserInfoDo userInfoDo = userInfoMapper.getUserInfoByAccount(account);
        if(userInfoDo != null){
            cardInfo.setAge(userInfoDo.getAge());
            cardInfo.setName(userInfoDo.getName());
            cardInfo.setPublicKey(userInfoDo.getDid());
            cardInfo.setIdentityNumber(userInfoDo.getIdCard());
            if(userInfoDo.getAge() < 18){
                cardInfo.setYouthMode(true);
                // TODO: 后续更改防止沉迷逻辑
                cardInfo.setAntiAddiction(true);
            } else {
                cardInfo.setYouthMode(false);
                cardInfo.setAntiAddiction(false);
            }
            userInfoResult.setDidcardinfo(cardInfo);
            userInfoResult.setMsg("success");
        } else {
            userInfoResult.setDidcardinfo(cardInfo);
            userInfoResult.setMsg("fail");
        }
        responseData.setResult(userInfoResult);
        return responseData;
    }


}
