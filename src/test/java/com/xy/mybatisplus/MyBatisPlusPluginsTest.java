package com.xy.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xy.mybatisplus.mapper.ProductMapper;
import com.xy.mybatisplus.mapper.UserMapper;
import com.xy.mybatisplus.pojo.Product;
import com.xy.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPluginsTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;


    @Test
    void testPage() {
        Page<User> page = new Page<User>(2,3);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal()  );
        System.out.println(page);

    }


    @Test
    void testPageVo() {
        Page<User> page = new Page<>(1,2);
        Page<User> pageVo = userMapper.selectPageVo(page, 20);
        System.out.println(pageVo);

    }

    @Test
    void testProduct01() {
        Product productLi = productMapper.selectById(1);
        System.out.println("小李:"+productLi.getPrice());

        Product productWang = productMapper.selectById(1);
        System.out.println("小王:"+productWang.getPrice());

        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        productWang.setPrice(productWang.getPrice() - 30);
        productMapper.updateById(productWang);

        Product productLaoBan = productMapper.selectById(1);
        System.out.println("老板::" + productLaoBan.getPrice());
    }
}
