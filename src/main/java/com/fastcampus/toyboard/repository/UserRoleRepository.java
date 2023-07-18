package com.fastcampus.toyboard.repository;

import com.fastcampus.toyboard.dto.UserRoleDto;
import com.fastcampus.toyboard.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleRepository {
    List<UserRoleDto> findAllWithAuthority();
    int updateById(UserRoleDto userRoleDto);
}
