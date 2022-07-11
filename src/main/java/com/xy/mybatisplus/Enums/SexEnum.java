package com.xy.mybatisplus.Enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Data;


public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2, "女");

    @EnumValue  ///将注解所标识的的属性的值存储到数据库中
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
}
