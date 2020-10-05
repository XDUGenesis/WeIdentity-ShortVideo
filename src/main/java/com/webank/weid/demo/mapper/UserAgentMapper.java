package com.webank.weid.demo.mapper;

import com.webank.weid.demo.common.dos.WeIdDo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: ningque
 * @Date: 2020/10/4
 * @Version 1.0
 */
public interface UserAgentMapper {
    /**
     * 插入注册的DID信息
     *
     * @param weIdDo DID信息
     * @return 返回该sql更新的记录数，如果>=1,表示插入成功
     */
    int insertDID(WeIdDo weIdDo);

    /**
     * 根据账户名查询用户信息
     *
     * @param account 账户名
     * @return 返回查询结果
     */
    WeIdDo findByAccount(@Param("account") String account);
}
