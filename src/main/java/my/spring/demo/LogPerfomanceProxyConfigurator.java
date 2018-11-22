package my.spring.demo;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class LogPerfomanceProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T> T wrapWithProxy(T t, Class<T> type) {
//        boolean isAnnotationOnAnyMethod = Arrays.stream(type.getDeclaredMethods()).anyMatch(m -> m.isAnnotationPresent(LogPerformance.class));
//
//        if (type.isAnnotationPresent(LogPerformance.class) || isAnnotationOnAnyMethod) {
//            if (type.getInterfaces().length == 0) {
//                return (T) Enhancer.create(type, new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//                        Method typeMethod = type.getMethod(method.getName(), method.getParameterTypes());
//                        return invokeMethod(type, method, typeMethod, t, objects);
//                    }
//                });
//            } else {
//                return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(),
//                        (proxy, method, args) -> {
//                            Method typeMethod = type.getMethod(method.getName(), method.getParameterTypes());
//                            return invokeMethod(type, method, typeMethod, t, args);
//                        });
//            }
//        }
//        return t;
        return null;
    }

    private Object invokeMethod(Class type, Method methodToInvoke, Method typeMethod, Object t, Object[] args) throws InvocationTargetException, IllegalAccessException {
        if (typeMethod.isAnnotationPresent(LogPerformance.class) || type.isAnnotationPresent(LogPerformance.class)) {
            new PerformanceLogger().logStart(methodToInvoke);
            Object result = methodToInvoke.invoke(t, args);
            new PerformanceLogger().logEnd(methodToInvoke);
            return result;
        }
        return methodToInvoke.invoke(t, args);
    }
}
