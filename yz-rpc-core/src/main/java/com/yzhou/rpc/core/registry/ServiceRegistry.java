package com.yzhou.rpc.core.registry;

import com.yzhou.rpc.common.extension.SPI;

import java.net.InetSocketAddress;

@SPI
public interface ServiceRegistry {
    /**
     * 注册服务
     *
     * @param rpcServerName
     * @param inetSocketAddress
     */
    void registerService(String rpcServerName, InetSocketAddress inetSocketAddress);
}
