package com.webank.weid.demo.service.impl;

import com.webank.weid.demo.common.dos.UserInfoDo;
import com.webank.weid.demo.common.dos.UserLogInfoDo;
import com.webank.weid.demo.common.dos.WeIdDo;
import com.webank.weid.demo.common.request.UserInfoRequest;
import com.webank.weid.demo.common.response.LogInfo;
import com.webank.weid.demo.common.response.UserLogInfoResult;
import com.webank.weid.demo.common.util.IpUtil;
import com.webank.weid.demo.mapper.UserInfoMapper;
import com.webank.weid.demo.mapper.UserLogInfoMapper;
import com.webank.weid.demo.service.UserLogService;
import com.webank.weid.protocol.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
@Service
public class UserLogServiceImpl implements UserLogService {
    @Autowired
    private IpUtil ipUtil;

    @Autowired
    private UserLogInfoMapper userLogInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 插入日志记录
     *
     * @param weIdDo 请求参数
     * @return 成功与否
     */
    @Override
    public boolean insertLogInfo(WeIdDo weIdDo) {
        UserLogInfoDo logInfoDo = new UserLogInfoDo();
        logInfoDo.setDID(weIdDo.getDid());
        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ipAddress = ipUtil.getIpAddr(request);
        String loginAddress = ipUtil.getLoginAddress(ipAddress);
        logInfoDo.setIpAddress(ipAddress);
        logInfoDo.setLoginAddress(loginAddress);
        Date date = new Date(System.currentTimeMillis());
        logInfoDo.setCreateTime(new Timestamp(date.getTime()));
        int ans = userLogInfoMapper.insertLogInfo(logInfoDo);
        if(ans == 1)
            return true;
        return false;
    }

    /**
     * 获取用户登陆日志
     *
     * @param userInfoRequest 请求（电话号）
     * @return 响应（日志记录）
     */
    @Override
    public ResponseData<UserLogInfoResult> recentLog(UserInfoRequest userInfoRequest) {
        ResponseData<UserLogInfoResult> responseData = new ResponseData<>();
        UserLogInfoResult userLogInfoResult = new UserLogInfoResult();
        List<LogInfo> logInfoList = new ArrayList<>();
        String account = userInfoRequest.getPhoneNumber();
        try {
            UserInfoDo userInfoDo = userInfoMapper.getUserInfoByAccount(account);
            String name = userInfoDo.getName();
            List<UserLogInfoDo> userLogInfoDoList = userLogInfoMapper.getUserLogInfo(userInfoDo.getDid());
            for(UserLogInfoDo logInfoDo : userLogInfoDoList){
                LogInfo logInfo = new LogInfo();
                logInfo.setName(name);
                logInfo.setDate(logInfoDo.getCreateTime());
                logInfo.setIpAddress(logInfoDo.getIpAddress());
                logInfo.setLoginAddress(logInfoDo.getLoginAddress());
                logInfoList.add(logInfo);
            }
            userLogInfoResult.setLogInfo(logInfoList);
            userLogInfoResult.setMsg("success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            userLogInfoResult.setLogInfo(logInfoList);
            userLogInfoResult.setMsg("fail");
        }
        responseData.setResult(userLogInfoResult);
        return responseData;
    }
}
