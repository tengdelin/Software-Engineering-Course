package com.example.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
public class StuController {
    @Resource
    StudentMapper studentmapper;

    @PostMapping
    public Result<?> save(@RequestBody Student student) {
        if (student.getName()==null){
            return Result.error("1","用户名不能为空");
        }
        studentmapper.insert(student);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Student> wrapper = Wrappers.<Student>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            System.out.println("----"+StrUtil.isNotBlank(search));
            wrapper.like(Student::getName, search);
        }
        Page<Student> stuPage = studentmapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(stuPage);
    }

    @PutMapping
    public Result<?> update(@RequestBody Student student) {
        studentmapper.updateById(student);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        studentmapper.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Long id) {
        return Result.success(studentmapper.selectById(id));
    }

}



