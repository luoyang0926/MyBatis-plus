package com.xy.mybatisplus;

import com.xy.mybatisplus.pojo.User;
import com.xy.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testCount() {
        long count = userService.count();
        System.out.println(count);
    }

    @Test
    void testInsertMore() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("老六"+i);
            list.add(user);
        }

        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }

    @Test
    void test1() {
     //   boolean b = userService.save(new User(null, "大大", "asd@qq.com", 13));
     //   System.out.println(b);
    }

}
