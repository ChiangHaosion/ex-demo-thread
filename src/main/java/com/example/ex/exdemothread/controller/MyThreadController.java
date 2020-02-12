package com.example.ex.exdemothread.controller;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author Haosion
 */
@Controller
public class MyThreadController {

    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/action")
    @ResponseBody
    public Object xMain() {
        long start = System.currentTimeMillis();
        ThreadFactory threadFactory = r -> new Thread(r,"thread-name-"+r.hashCode());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                1L,TimeUnit.SECONDS, new LinkedBlockingDeque<>(),threadFactory);

        for (int i = 0; i < 10000; i++) {
            User user = new User(UUID.randomUUID().toString().substring(0,4), RandomUtil.randomInt(1,100));
            threadPoolExecutor.execute(()->{
                int x=userMapper.insertTodbb(user);
            });
        }
        threadPoolExecutor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (end - start) + "ms");
        return "Ok";

    }
}