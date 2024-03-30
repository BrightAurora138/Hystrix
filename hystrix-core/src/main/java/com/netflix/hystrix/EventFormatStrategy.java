package com.netflix.hystrix;

public interface EventFormatStrategy {
    String formatEvent(HystrixEventType eventType, int count);
}

