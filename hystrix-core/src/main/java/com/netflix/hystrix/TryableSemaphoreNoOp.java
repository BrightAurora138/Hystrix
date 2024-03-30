package com.netflix.hystrix;

public class TryableSemaphoreNoOp implements TryableSemaphore {
    public static final TryableSemaphore DEFAULT = new TryableSemaphoreNoOp();

    @Override
    public boolean tryAcquire() {
        return true;
    }

    @Override
    public void release() {
        // 实现...
    }

    @Override
    public int getNumberOfPermitsUsed() {
        return 0;
    }
}

