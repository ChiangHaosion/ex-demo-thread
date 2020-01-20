package com.example.ex.exdemothread.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Haosion
 * 两个函数操作的数据都会回滚。
 */

@Component
public class AClass {

    Logger logger = LoggerFactory.getLogger(AClass.class);

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void aFunction() {
        logger.info("调用aFunction函数");
        //todo: 操作A(增，删，该)
        userMapper.insertTodbb(new User("ww",10));
        aInnerFunction(); // 调用内部没有添加@Transactional注解的函数
    }

    private void aInnerFunction() {
        logger.info("调用aInnerFunction函数");
        //todo: 操作B(做了增，删，改 操作)
        userMapper.insertTodbb(new User("ww",10));
        throw new RuntimeException("函数执行有异常!");
    }

}