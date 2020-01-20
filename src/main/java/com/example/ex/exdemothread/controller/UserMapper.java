package com.example.ex.exdemothread.controller;

import org.apache.ibatis.annotations.Insert;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author Haosion
 * @Date 2020/1/18
 * @Version V1.0
 **/
public interface UserMapper {
    @Insert("insert into user(name,age) values(#{name},#{age})")
    int insertTodbb(User user);
}
