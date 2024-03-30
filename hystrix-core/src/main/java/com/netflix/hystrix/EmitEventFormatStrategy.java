package com.netflix.hystrix;

public class EmitEventFormatStrategy implements EventFormatStrategy {
    @Override
    public String formatEvent(HystrixEventType eventType, int count) {
        return count > 1 ? eventType.toString() + "x" + count : eventType.toString();
    }
}
