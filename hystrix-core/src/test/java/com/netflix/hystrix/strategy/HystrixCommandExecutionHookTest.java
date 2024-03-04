package com.netflix.hystrix.strategy;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.HystrixPlugins.LoggerSupplier;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixDynamicProperties;
import com.netflix.hystrix.strategy.properties.HystrixDynamicPropertiesSystemProperties;
import com.netflix.hystrix.strategy.properties.HystrixDynamicProperty;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;

public class HystrixCommandExecutionHookTest {

    @Test
    public void testCustomCommandExecutionHookInvocation() {
        CustomCommandExecutionHook customHook = new CustomCommandExecutionHook();
        HystrixPlugins.getInstance().registerCommandExecutionHook(customHook);

        // Execute a dummy command to trigger the hook
        new DummyCommand().execute();

        assertTrue("Expected onStart to be called on the custom command execution hook", customHook.isOnStartCalled());
    }

}