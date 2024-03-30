package com.netflix.hystrix;

public class DefaultEventFormatStrategy implements EventFormatStrategy {
    @Override
    public String formatEvent(HystrixEventType eventType, int count) {
        return eventType.toString();
    }
}
