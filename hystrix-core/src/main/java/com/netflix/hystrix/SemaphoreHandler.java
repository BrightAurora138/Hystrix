package com.netflix.hystrix;
import java.util.concurrent.ConcurrentHashMap;

import com.netflix.hystrix.strategy.properties.HystrixProperty;

public class SemaphoreHandler {
    protected static final ConcurrentHashMap<String, TryableSemaphore> fallbackSemaphorePerCircuit = new ConcurrentHashMap<>();
    protected static final ConcurrentHashMap<String, TryableSemaphore> executionSemaphorePerCircuit = new ConcurrentHashMap<>();

    public TryableSemaphore getFallbackSemaphore(String commandKey, HystrixProperty<Integer> fallbackSemaphoreMaxConcurrentRequests) {
        return fallbackSemaphorePerCircuit.computeIfAbsent(commandKey, k -> new TryableSemaphoreActual(fallbackSemaphoreMaxConcurrentRequests));
    }

    public TryableSemaphore getExecutionSemaphore(String commandKey, HystrixProperty<Integer> executionSemaphoreMaxConcurrentRequests) {
        return executionSemaphorePerCircuit.computeIfAbsent(commandKey, k -> new TryableSemaphoreActual(executionSemaphoreMaxConcurrentRequests));
    }
}

