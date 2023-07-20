package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.dto.BoardUserDto;
import com.fastcampus.toyboard.repository.BoardUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    @Autowired
    private final BoardUserRepository boardUserRepository;

    public List<BoardUserDto> getBoardListWithUser(){
        return boardUserRepository.findAll();
    }

    public void updateHide(Long boardId){

        BoardUserDto boardUserDto = boardUserRepository.findById(boardId);

        if(boardUserDto.getHide() == false){
            boardUserDto.setHide(true);
        }
        else if(boardUserDto.getHide() == true){
            boardUserDto.setHide(false);
        }

        boardUserRepository.updateHideById(boardUserDto);
    }

    public void deleteBoard(Long boardId){
        boardUserRepository.deleteById(boardId);
    }

    public void updateBlack(Long boardId) {
        boardUserRepository.updateBlackById(boardId);
    }
}
