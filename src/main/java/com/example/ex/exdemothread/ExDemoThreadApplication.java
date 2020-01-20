package com.example.ex.exdemothread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Haosion
 */
@SpringBootApplication
@EnableTransactionManagement
public class ExDemoThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExDemoThreadApplication.class, args);
    }

}
