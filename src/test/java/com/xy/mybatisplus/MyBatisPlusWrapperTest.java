package com.xy.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xy.mybatisplus.mapper.UserMapper;
import com.xy.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusWrapperTest {


    @Autowired
    private UserMapper userMapper;
    @Test
    void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    @Test
    void testSelect2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);

    }

    @Test
    void testDelete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int i = userMapper.delete(queryWrapper);
        System.out.println(i);
    }

    @Test
    void test1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNotNull("email"));

        User user = new User();
        user.setName("小红");
        user.setEmail("qq@com");
        int i = userMapper.update(user, queryWrapper);
        System.out.println(i);

    }

    @Test
    void test02() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> user = queryWrapper.select("name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(user);
        maps.forEach(System.out::println);
    }

    @Test
    void test03() {
        String username = "a";
        Integer ageBegin=null;
        Integer endBegin = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(endBegin != null, "age", endBegin);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }



}
