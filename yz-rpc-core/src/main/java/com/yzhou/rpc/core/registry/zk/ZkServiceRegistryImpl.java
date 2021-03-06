package com.yzhou.rpc.core.registry.zk;

import com.yzhou.rpc.core.registry.ServiceRegistry;
import com.yzhou.rpc.core.registry.zk.util.CuratorUtils;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;

public class ZkServiceRegistryImpl implements ServiceRegistry {

    @Override
    public void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress) {
        String servicePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + rpcServiceName + inetSocketAddress.toString();
        CuratorFramework zkClient = CuratorUtils.getZkClient(null);
        CuratorUtils.createPersistentNode(zkClient, servicePath);
    }
}
