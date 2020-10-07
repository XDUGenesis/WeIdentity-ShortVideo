package com.webank.weid.demo.mapper;

import com.webank.weid.demo.common.dos.UserLogInfoDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ningque
 * @Date: 2020/10/7
 * @Version 1.0
 */
@Mapper
public interface UserLogInfoMapper {
    /**
     * 插入登陆日志信息
     * @param userLogInfoDo 日志信息
     * @return 返回该sql更新的记录数，如果>=1,表示插入成功
     */
    int insertLogInfo(UserLogInfoDo userLogInfoDo);

    /**
     * 获取用户登陆日志（最近五条）
     * @param did did
     * @return 日志记录
     */
    List<UserLogInfoDo> getUserLogInfo(@Param("did") String did);
}
