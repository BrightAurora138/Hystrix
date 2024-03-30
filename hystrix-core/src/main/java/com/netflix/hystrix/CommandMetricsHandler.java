package com.netflix.hystrix;

public class CommandMetricsHandler {
    private final HystrixCommandMetrics metrics;

    public CommandMetricsHandler(HystrixCommandMetrics metrics) {
        this.metrics = metrics;
    }

    public void markCommandStart(HystrixCommandKey commandKey, HystrixThreadPoolKey threadPoolKey, HystrixCommandProperties.ExecutionIsolationStrategy strategy) {
        metrics.markCommandStart(commandKey, threadPoolKey, strategy);
    }

    public void markCommandDone(ExecutionResult executionResult, HystrixCommandKey commandKey, HystrixThreadPoolKey threadPoolKey, boolean executionStarted) {
        metrics.markCommandDone(executionResult, commandKey, threadPoolKey, executionStarted);
    }
}
