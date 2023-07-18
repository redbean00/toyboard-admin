package com.fastcampus.toyboard.repository;

import com.fastcampus.toyboard.dto.UserRoleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    List<UserRoleDto> findAll();
    int updateById(UserRoleDto userRoleDto);
}
