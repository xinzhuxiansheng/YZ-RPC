package com.yzhou.rpc.core.loadbalance;

import com.yzhou.rpc.common.extension.SPI;
import com.yzhou.rpc.core.remoting.dto.RpcRequest;

import java.util.List;

/**
 * Interface to the load balancing policy
 *
 */
@SPI
public interface LoadBalance {
    /**
     * Choose one from the list of existing service addresses list
     *
     * @param serviceAddresses Service address list
     * @return target service address
     */
    String selectServiceAddress(List<String> serviceAddresses, RpcRequest rpcRequest);
}
