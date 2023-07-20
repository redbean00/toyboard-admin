package com.fastcampus.toyboard.repository;

import com.fastcampus.toyboard.dto.BoardUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardUserRepository {

    List<BoardUserDto> findAll();

    BoardUserDto findById(Long boardId);

    int deleteById(Long boardId);

    int updateHideById(BoardUserDto boardUserDto);

    int updateBlackById(Long boardId);

}
