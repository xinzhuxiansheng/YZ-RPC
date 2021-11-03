package com.yzhou.rpc.core.config;

public class NettyRpcClientConfig {
    private String zkAddr;
    private String zkNameSpace;

    public String getZkAddr() {
        return zkAddr;
    }

    public void setZkAddr(String zkAddr) {
        this.zkAddr = zkAddr;
    }

    public String getZkNameSpace() {
        return zkNameSpace;
    }

    public void setZkNameSpace(String zkNameSpace) {
        this.zkNameSpace = zkNameSpace;
    }
}
