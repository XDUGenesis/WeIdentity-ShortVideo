package com.webank.weid.demo.mapper;

import com.webank.weid.demo.common.dos.UserInfoDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
@Mapper
public interface UserInfoMapper {
    /**
     * 插入用户信息
     *
     * @param userInfoDo 用户信息
     * @return 返回该sql更新的记录数，如果>=1,表示插入成功
     */
    int insertUserInfo(UserInfoDo userInfoDo);
}
