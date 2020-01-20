package com.example.ex.exdemothread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AAClass
 * @Description: 两个函数里面的数据库操作都成功。回滚失效:  回滚的动作发生在当有@Transactional注解函数有对应异常抛出时才会回滚
 * @Author Haosion
 * @Date 2020/1/20
 * @Version V1.0
 **/
@Component
public class AAClass {


    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void aFunction() {
        //todo: 数据库操作A(增，删，该)
        userMapper.insertTodbb(new User("ww", 11));
        try {
            aInnerFunction(); // 调用内部没有添加@Transactional注解的函数
        } catch (Exception e) {
            //捕捉到异常
            e.printStackTrace();
        }
    }

    private void aInnerFunction() {
        //todo: 操作数据B(做了增，删，改 操作)
        userMapper.insertTodbb(new User("ww", 12));
        throw new RuntimeException("函数执行有异常!");
    }
}
