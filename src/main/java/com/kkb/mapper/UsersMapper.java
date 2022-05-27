package com.kkb.mapper;

import com.kkb.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    Users queryById(int userId);
    Users queryById2(int userId);
}
