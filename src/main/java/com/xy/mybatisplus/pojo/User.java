package com.xy.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.xy.mybatisplus.Enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@TableName("t_user")
public class User {
    //@TableId(type = IdType.AUTO) // 将该字段作为主键id
    private Long id;

    //@TableField("t_name")
    private String name;

    private String email;

    private Integer age;

    private SexEnum sex;

    @TableLogic
    private Integer isDelete;
}
