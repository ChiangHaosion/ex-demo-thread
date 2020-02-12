package com.example.ex.exdemothread;

import com.example.ex.exdemothread.controller.AAClass;
import com.example.ex.exdemothread.controller.AClass;
import com.example.ex.exdemothread.controller.BClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName Test01
 * @Description: TODO
 * @Author Haosion
 * @Date 2020/1/19
 * @Version V1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 {
    private static Logger logger = LoggerFactory.getLogger(Test01.class);

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    @Autowired
    private AClass aClass;
    @Autowired
    private AAClass aaClass;

    @Autowired
    private BClass bClass;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //初始化MockMvc对象
    }

    @Test
    public void testInsertManyInMulThread() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/action"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testA() {
        aClass.aFunction();
    }

    @Test
    public void testAA() {
        aaClass.aFunction();
    }

    @Test
    public void testC() {
        bClass.bFcunction();
    }

    @Test
    public void test() {

        //卖票
        //创建线程任务
        Tickets t = new Tickets();
        //创建线程对象，共计三条，将创建的线程任务传入线程对象
        Thread t0 = new Thread(t);
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        //开始线程
        logger.info("开始啦！！");
        t0.start();
        t1.start();
        t2.start();
        logger.info("结束啦！！");

    }

    class Tickets implements Runnable {
        //多个线程共享，必须要用成员变量
        private int ticket = 100;
        private Object obj = new Object();

        //重写run
        public void run() {
            while (true) {
                synchronized (obj) {//把会出现问题的代码放入同步代码块中。
                    if (ticket > 0) {
                        //获取名称并让倒售出票，--先赋值再运算，当ticket变成100，成员变量成99
                        System.out.println(Thread.currentThread().getName() + "售出第" + ticket-- + "张票");
                    }
                }
            }
        }
    }
    @Test
    public void testMiss(){

    }


}
