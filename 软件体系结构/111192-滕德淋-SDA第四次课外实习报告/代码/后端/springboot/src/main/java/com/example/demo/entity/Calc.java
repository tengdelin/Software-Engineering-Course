package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("Calc")
@Data
public class Calc {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String plane_type;
    private String person_type;
    private String vip_type;
    private String seat_type;
    private String region;
    private Integer num;
    private String spec1;
    private String spec2;
    private Integer length1;
    private Integer weight1;
    private Integer length2;
    private Integer weight2;
    private Integer price;

    private Integer res;
}
