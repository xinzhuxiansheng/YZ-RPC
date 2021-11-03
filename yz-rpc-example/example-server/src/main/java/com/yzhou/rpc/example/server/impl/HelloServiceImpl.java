package com.yzhou.rpc.example.server.impl;

import com.yzhou.rpc.core.annotation.RpcService;
import com.yzhou.rpc.example.api.Hello;
import com.yzhou.rpc.example.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
@RpcService(group = "test1", version = "version1")
public class HelloServiceImpl implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    static {
        System.out.println("HelloServiceImpl被创建");
    }

    @Override
    public String hello(Hello hello) {
        logger.info("HelloServiceImpl收到: {}.", hello.getMessage());
        String result = "Hello description is " + hello.getDescription();
        logger.info("HelloServiceImpl返回: {}.", result);
        return result;
    }
}
