package com.netflix.hystrix;

public class FallbackEmitEventFormatStrategy implements EventFormatStrategy {
    @Override
    public String formatEvent(HystrixEventType eventType, int count) {
        return count > 1 ? eventType.toString() + "x" + count : eventType.toString();
    }
}
