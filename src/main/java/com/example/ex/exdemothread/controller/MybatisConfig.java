package com.example.ex.exdemothread.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisConfig
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/11/7
 * @Version V1.0
 **/

@Configuration
@MapperScan("com.example.ex.exdemothread.controller")
public class MybatisConfig {
}
