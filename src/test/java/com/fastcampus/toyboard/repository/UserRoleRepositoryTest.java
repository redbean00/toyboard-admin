package com.fastcampus.toyboard.repository;

import com.fastcampus.toyboard.dto.UserRoleDto;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MybatisTest
public class UserRoleRepositoryTest {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    public void findAllWithAuthorityTest(){
        //given

        //when
        List<UserRoleDto> userRoleDtoList = userRoleRepository.findAllWithAuthority();

        //then
        System.out.println(userRoleDtoList.get(0).getUserId());
//        Assertions.assertThat(userRoleDtoList.get(0).getAuthority().equals("SPROUD"));
//        Assertions.assertThat(userRoleDtoList.get(1).getAuthority().equals("GREAT"));
//        Assertions.assertThat(userRoleDtoList.get(2).getAuthority().equals("BLACK"));
//        Assertions.assertThat(userRoleDtoList.get(3).getAuthority().equals("ADMIN"));

    }

}
