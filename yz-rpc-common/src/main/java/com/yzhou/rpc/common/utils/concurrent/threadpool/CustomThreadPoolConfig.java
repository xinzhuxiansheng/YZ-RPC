package com.yzhou.rpc.common.utils.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 线程池自定义配置类，可自行根据业务场景修改配置参数。
 */

public class CustomThreadPoolConfig {
    /**
     * 线程池默认参数
     */
    private static final int DEFAULT_CORE_POOL_SIZE = 10;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE_SIZE = 100;
    private static final int DEFAULT_KEEP_ALIVE_TIME = 1;
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MINUTES;
    private static final int DEFAULT_BLOCKING_QUEUE_CAPACITY = 100;
    private static final int BLOCKING_QUEUE_CAPACITY = 100;
    /**
     * 可配置参数
     */
    private int corePoolSize = DEFAULT_CORE_POOL_SIZE;
    private int maximumPoolSize = DEFAULT_MAXIMUM_POOL_SIZE_SIZE;
    private long keepAliveTime = DEFAULT_KEEP_ALIVE_TIME;
    private TimeUnit unit = DEFAULT_TIME_UNIT;
    // 使用有界队列
    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(BLOCKING_QUEUE_CAPACITY);

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public BlockingQueue<Runnable> getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
    }
}
