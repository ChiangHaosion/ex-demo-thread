package com.example.ex.exdemothread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName BClass
 * @Description: aFunction添加注解，bFunction不添加注解。bFunction抛异常。结果：两个函数对数据库的操作都回滚了。
 * @Author Haosion
 * @Date 2020/1/20
 * @Version V1.0
 **/
@Component
public class BClass {
    @Autowired
    private UserMapper userMapper;

    private CClass cClass;

    @Autowired
    public void setbClass(CClass bClass) {
        this.cClass = bClass;
    }

    @Transactional(rollbackFor = Exception.class)
    public void bFcunction() {
        //todo: 数据库操作A(增，删，该)
        userMapper.insertTodbb(new User("ww",10));
        cClass.cFunction();
    }


}
