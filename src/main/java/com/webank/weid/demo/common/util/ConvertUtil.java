package com.webank.weid.demo.common.util;

import com.webank.weid.demo.common.dos.UserInfoDo;
import com.webank.weid.demo.common.dos.WeIdDo;
import com.webank.weid.demo.common.request.UserInfoRequest;
import com.webank.weid.demo.common.request.WeIdRequest;
import org.springframework.stereotype.Component;

/**
 * @Author: ningque
 * @Date: 2020/10/4
 * @Version 1.0
 */
@Component
public class ConvertUtil {

    public WeIdDo convertToWeIdDo(WeIdRequest request) {
        WeIdDo weIdDo = new WeIdDo();
        weIdDo.setAccount(request.getPhoneNumber());
        weIdDo.setPassword(request.getPassword());
        weIdDo.setCreateTime(request.getCreateTime());
        weIdDo.setUpdateTime(request.getUpdateTime());
        return weIdDo;
    }

    public UserInfoDo convertToUserInfoDo(UserInfoRequest userInfoRequest) {
        UserInfoDo infoDo = new UserInfoDo();
        infoDo.setAccount(userInfoRequest.getPhoneNumber());
        infoDo.setAge(userInfoRequest.getAge());
        infoDo.setIdCard(userInfoRequest.getIdentityNumber());
        infoDo.setName(userInfoRequest.getName());
        infoDo.setSex(userInfoRequest.getSex());
        return infoDo;
    }
}
