package com.yzhou.rpc.example.server;

import com.yzhou.rpc.core.annotation.RpcScan;
import com.yzhou.rpc.core.config.RpcServiceConfig;
import com.yzhou.rpc.core.remoting.transport.netty.server.NettyRpcServer;
import com.yzhou.rpc.example.api.HelloService;
import com.yzhou.rpc.example.server.impl.HelloServiceImpl2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Server: Automatic registration service via @RpcService annotation
 *
 */
@RpcScan(basePackage = {"com.yzhou.rpc"})
public class NettyServerMain {
    public static void main(String[] args) {
        // Register service via annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NettyServerMain.class);
        NettyRpcServer nettyRpcServer = (NettyRpcServer) applicationContext.getBean("nettyRpcServer");
        // Register service manually
        HelloService helloService2 = new HelloServiceImpl2();
        RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
                .group("test2").version("version2").service(helloService2).build();
        nettyRpcServer.registerService(rpcServiceConfig);
        nettyRpcServer.start();
    }
}