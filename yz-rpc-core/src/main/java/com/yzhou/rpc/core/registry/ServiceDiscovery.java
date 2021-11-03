package com.yzhou.rpc.core.registry;

import com.yzhou.rpc.common.extension.SPI;
import com.yzhou.rpc.core.remoting.dto.RpcRequest;

import java.net.InetSocketAddress;

@SPI
public interface ServiceDiscovery {
    /**
     * 根据服务名称，查找服务
     *
     * @param rpcRequest
     * @return
     */
    InetSocketAddress lookupService(RpcRequest rpcRequest);
}
