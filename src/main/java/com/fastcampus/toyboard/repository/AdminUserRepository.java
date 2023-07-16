package com.fastcampus.toyboard.repository;

import com.fastcampus.toyboard.dto.AdminUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminUserRepository {
    AdminUserDto findById(Long id);


}
