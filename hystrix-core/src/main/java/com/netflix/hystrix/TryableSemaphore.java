package com.netflix.hystrix;

public interface TryableSemaphore {
    boolean tryAcquire();
    void release();
    int getNumberOfPermitsUsed();
}

