package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("result")
@Data
public class CResult {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer result;
}
