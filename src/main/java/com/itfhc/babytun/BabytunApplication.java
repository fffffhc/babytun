package com.itfhc.babytun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.itfhc.babytun")//mybatis在spring boot启动时自动扫描的接口
@EnableCaching//开启声明式缓存，利用注解开启缓存的读写
@EnableScheduling//自动任务调度
public class BabytunApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabytunApplication.class, args);
    }

}
