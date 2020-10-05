package com.webank.weid.demo.mapper;

import com.webank.weid.demo.common.dos.WeIdDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: ningque
 * @Date: 2020/10/4
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserAgentMapperTest {
    @Autowired
    private UserAgentMapper userAgentMapper;

    @Test
    public void testInsertDID(){
        WeIdDo weIdDo = new WeIdDo();
        weIdDo.setDid("asdfgggh");
        weIdDo.setAccount("1234567");
        weIdDo.setPassword("dnaidnaivnai");
        weIdDo.setCreateTime((Timestamp) new Date());
        weIdDo.setUpdateTime((Timestamp) new Date());

        System.out.println(userAgentMapper.insertDID(weIdDo));
    }
}
