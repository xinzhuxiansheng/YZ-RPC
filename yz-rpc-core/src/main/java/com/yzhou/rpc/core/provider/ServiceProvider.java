package com.yzhou.rpc.core.provider;

import com.yzhou.rpc.core.config.RpcServiceConfig;

public interface ServiceProvider {
    /**
     * 添加服务
     *
     * @param rpcServiceConfig
     */
    void addService(RpcServiceConfig rpcServiceConfig);

    /**
     * 获取服务
     *
     * @param rpcServiceName
     * @return
     */
    Object getService(String rpcServiceName);

    /**
     * 发布服务
     *
     * @param rpcServiceConfig
     */
    void publishService(RpcServiceConfig rpcServiceConfig);
}
