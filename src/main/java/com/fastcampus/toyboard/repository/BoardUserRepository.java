package com.fastcampus.toyboard.repository;

import com.fastcampus.toyboard.dto.BoardUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardUserRepository {

    List<BoardUserDto> findAll();

    int deleteById(BoardUserDto boardUserDto);

    int updateHideById(BoardUserDto boardUserDto);

    int updateBlackById(BoardUserDto boardUserDto);

}
