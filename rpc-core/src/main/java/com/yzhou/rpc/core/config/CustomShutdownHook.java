package com.yzhou.rpc.core.config;

import com.yzhou.rpc.common.utils.concurrent.threadpool.ThreadPoolFactoryUtils;
import com.yzhou.rpc.core.registry.zk.util.CuratorUtils;
import com.yzhou.rpc.core.remoting.transport.netty.server.NettyRpcServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * When the server  is closed, do something such as unregister all services
 */
public class CustomShutdownHook {
    private static final Logger logger = LoggerFactory.getLogger(CustomShutdownHook.class);
    private static final CustomShutdownHook CUSTOM_SHUTDOWN_HOOK = new CustomShutdownHook();

    public static CustomShutdownHook getCustomShutdownHook() {
        return CUSTOM_SHUTDOWN_HOOK;
    }

    public void clearAll() {
        logger.info("addShutdownHook for clearAll");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), NettyRpcServer.PORT);
                CuratorUtils.clearRegistry(CuratorUtils.getZkClient(), inetSocketAddress);
            } catch (UnknownHostException ignored) {
            }
            ThreadPoolFactoryUtils.shutDownAllThreadPool();
        }));
    }
}
