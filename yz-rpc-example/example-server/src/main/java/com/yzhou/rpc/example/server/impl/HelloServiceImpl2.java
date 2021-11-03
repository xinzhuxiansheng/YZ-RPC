package com.yzhou.rpc.example.server.impl;

import com.yzhou.rpc.example.api.Hello;
import com.yzhou.rpc.example.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class HelloServiceImpl2 implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl2.class);
    static {
        System.out.println("HelloServiceImpl2被创建");
    }

    @Override
    public String hello(Hello hello) {
        logger.info("HelloServiceImpl2收到: {}.", hello.getMessage());
        String result = "Hello description is " + hello.getDescription();
        logger.info("HelloServiceImpl2返回: {}.", result);
        return result;
    }
}
