package com.fastcampus.toyboard.repository;

import com.fastcampus.toyboard.dto.AdminBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminBoardRepository {
    List<AdminBoardDto> findAll();
    AdminBoardDto findById(Long id);
    void deleteById(Long id);
    void updateById(Long id, Integer hide);
}
