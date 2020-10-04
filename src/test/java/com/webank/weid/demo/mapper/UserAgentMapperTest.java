package com.webank.weid.demo.mapper;

import com.webank.weid.demo.common.dos.WeIdDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: ningque
 * @Date: 2020/10/4
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAgentMapperTest {
    @Autowired
    private UserAgentMapper userAgentMapper;

    @Test
    public void testInsertDID(){
        WeIdDo weIdDo = new WeIdDo();
        weIdDo.setDid("asdfgggh");
        weIdDo.setSex("男");
        weIdDo.setNumber("12345678");
        weIdDo.setIdCard("daivnaivna8978");
        weIdDo.setAge(20);

        System.out.println(userAgentMapper.insertDID(weIdDo));
    }
}
