package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.dto.AdminBoardDto;
import com.fastcampus.toyboard.repository.AdminBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBoardService {

    @Autowired
    AdminBoardRepository adminBoardRepository;

    public List<AdminBoardDto> findBoardList(){
        List<AdminBoardDto> adminBoardDtoList = adminBoardRepository.findAll();
        return adminBoardDtoList;
    }

    public void deleteBoardById(Long id){
        adminBoardRepository.deleteById(id);
    }

    public void hideBoardById(Long id){
        AdminBoardDto adminBoardDto = adminBoardRepository.findById(id);

        if(adminBoardDto.getHide() == 1){
            adminBoardRepository.updateById(adminBoardDto.getUserId(), 0);
        }else{
            adminBoardRepository.updateById(adminBoardDto.getUserId(), 1);
        }
    }

}
