package com.netflix.hystrix;

import com.netflix.hystrix.strategy.properties.HystrixProperty;
import java.util.concurrent.atomic.AtomicInteger;

public class TryableSemaphoreActual implements TryableSemaphore {
    protected final HystrixProperty<Integer> numberOfPermits;
    private final AtomicInteger count = new AtomicInteger(0);

    public TryableSemaphoreActual(HystrixProperty<Integer> numberOfPermits) {
        this.numberOfPermits = numberOfPermits;
    }

    @Override
    public boolean tryAcquire() {
        int currentCount = count.incrementAndGet();
        if (currentCount > numberOfPermits.get()) {
            count.decrementAndGet();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void release() {
        count.decrementAndGet();
    }

    @Override
    public int getNumberOfPermitsUsed() {
        return count.get();
    }
}

