package com.yzhou.rpc.core.registry.zk;

import com.yzhou.rpc.common.enums.RpcErrorMessageEnum;
import com.yzhou.rpc.common.exception.RpcException;
import com.yzhou.rpc.common.extension.ExtensionLoader;
import com.yzhou.rpc.core.loadbalance.LoadBalance;
import com.yzhou.rpc.core.registry.ServiceDiscovery;
import com.yzhou.rpc.core.registry.zk.util.CuratorUtils;
import com.yzhou.rpc.core.remoting.dto.RpcRequest;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * service discovery based on zookeeper
 *
 */
public class ZkServiceDiscoveryImpl implements ServiceDiscovery {
    private static final Logger logger = LoggerFactory.getLogger(ZkServiceDiscoveryImpl.class);
    private final LoadBalance loadBalance;

    public ZkServiceDiscoveryImpl() {
        this.loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("loadBalance");
    }

    @Override
    public InetSocketAddress lookupService(RpcRequest rpcRequest) {
        String rpcServiceName = rpcRequest.getRpcServiceName();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, rpcServiceName);
        if (serviceUrlList == null || serviceUrlList.size() == 0) {
            throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND, rpcServiceName);
        }
        // load balancing
        String targetServiceUrl = loadBalance.selectServiceAddress(serviceUrlList, rpcRequest);
        logger.info("Successfully found the service address:[{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);
    }
}
