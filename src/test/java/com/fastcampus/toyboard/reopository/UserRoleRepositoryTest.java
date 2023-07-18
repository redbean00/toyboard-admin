package com.fastcampus.toyboard.reopository;

import com.fastcampus.toyboard.dto.UserRoleDto;
import com.fastcampus.toyboard.repository.UserRoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("local")
public class UserRoleRepositoryTest {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    public void findAllWithAuthority(){
        //given & when
        List<UserRoleDto> userList = userRoleRepository.findAllWithAuthority();

        //then
        System.out.println(userList.get(0).getAuthority());
        Assertions.assertThat(userList.get(0).getAuthority()).isEqualTo("SPROUT");

    }

    @Test
    public void updateByIdTest(){
        //given
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(1L);
        userRoleDto.setAuthority("GREAT");

        //when
        int result = userRoleRepository.updateById(userRoleDto);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }
}
