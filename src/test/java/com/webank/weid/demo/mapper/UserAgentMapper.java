package com.webank.weid.demo.mapper;

import com.webank.weid.demo.common.dos.WeIdDo;
import org.mapstruct.Mapper;

/**
 * @Author: ningque
 * @Date: 2020/10/4
 * @Version 1.0
 */
@Mapper
public interface UserAgentMapper {
    /**
     * 插入注册的DID信息
     *
     * @param weIdDo DID信息
     * @return 返回该sql更新的记录数，如果>=1,表示插入成功
     */
    int insertDID(WeIdDo weIdDo);
}
