package my.spring.demo;

import java.lang.reflect.Proxy;

public class LogPerfomanceProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T> T wrapWithProxy(T t) {
        if (t.getClass().isAnnotationPresent(LogPerformance.class)) {
            return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(),
                (proxy, method, args) -> {
                new PerformanceLogger().logStart(method);
                Object result = method.invoke(t, args);
                new PerformanceLogger().logEnd(method);
                return result;
            });
        }
        return t;
    }
}
