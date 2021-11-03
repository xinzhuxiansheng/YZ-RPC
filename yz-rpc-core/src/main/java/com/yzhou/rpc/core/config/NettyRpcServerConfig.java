package com.yzhou.rpc.core.config;

public class NettyRpcServerConfig {
    private int port;
    private String zkAddr;
    private String zkNameSpace;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

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
