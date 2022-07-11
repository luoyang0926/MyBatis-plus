package com.xy.mybatisplus;

import com.xy.mybatisplus.Enums.SexEnum;
import com.xy.mybatisplus.mapper.UserMapper;
import com.xy.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test01() {
        User user = new User();
        user.setAge(23);
        user.setName("老师");
        user.setEmail("laoshi@qq.xom");
        user.setSex(SexEnum.MALE);
        int i = userMapper.insert(user);
        System.out.println(i);
    }
}
