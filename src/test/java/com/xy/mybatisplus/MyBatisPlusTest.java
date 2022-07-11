package com.xy.mybatisplus;

import com.xy.mybatisplus.mapper.UserMapper;
import com.xy.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    void testSelectList() {
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    void testInsert() {
      //  int i = userMapper.insert(new User(null, "老九", "2012162055@qq.com", 18));
    //    System.out.println(i);

    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(1545698913160048641L);
        System.out.println(user);
    }

    @Test
    void testSelectByIds() {
        List<String> list = new ArrayList();
        list.add("1L");
        list.add("2");
        list.add("3");
        List<User> users = userMapper.selectBatchIds(list);
        System.out.println(users);

    }

    @Test
    void testUpdate() {
      //  int i = userMapper.updateById(new User(1L, "王五", "aqwe!qq.com", 14));
      //  System.out.println(i);
    }

    @Test
    void testSelectMapById() {
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }

    @Test
    void delete() {
        int i = userMapper.deleteById(1L);
        System.out.println(i);
    }

}
