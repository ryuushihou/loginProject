package com.ryuushihou.backend.mapper;

import com.ryuushihou.backend.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    UserBean getUserByUsername(String username);

}
