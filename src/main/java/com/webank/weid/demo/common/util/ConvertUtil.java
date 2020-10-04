package com.webank.weid.demo.common.util;

import com.webank.weid.demo.common.dos.WeIdDo;
import com.webank.weid.demo.common.request.WeIdRequest;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Author: ningque
 * @Date: 2020/10/4
 * @Version 1.0
 */
@Component
public class ConvertUtil {

    public WeIdDo convertToWeIdDo(WeIdRequest request) {
        WeIdDo weIdDo = new WeIdDo();
        weIdDo.setDid(request.getDid());
        weIdDo.setAge(request.getAge());
        weIdDo.setIdCard(request.getIdCard());
        weIdDo.setNumber(request.getNumber());
        weIdDo.setSex(request.getSex());
//        weIdDo.setCreateTime(request.getCreateTime());
//        weIdDo.setUpdateTime();
        return weIdDo;
    }
}
