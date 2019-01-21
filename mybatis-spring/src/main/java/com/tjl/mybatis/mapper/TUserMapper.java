package com.tjl.mybatis.mapper;

import com.tjl.mybatis.entity.TUser;

public interface TUserMapper {
    TUser selectByPrimaryKey(Integer id);
}