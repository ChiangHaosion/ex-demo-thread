package com.example.ex.exdemothread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName BClass
 * @Description: TODO
 * @Author Haosion
 * @Date 2020/1/20
 * @Version V1.0
 **/
@Component
public class CClass {


    @Autowired
    private UserMapper userMapper;

    public void cFunction() {
        //todo: 数据库操作A(增，删，该)
        userMapper.insertTodbb(new User("ww",10));
        throw new RuntimeException("函数执行有异常!");
    }
}
