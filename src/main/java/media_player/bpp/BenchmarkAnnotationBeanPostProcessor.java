package media_player.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();

        Method[] methods = beanClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {

                Object proxy = Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                Method originalMethod = beanClass.getMethod(method.getName(), method.getParameterTypes());

                                if (originalMethod.isAnnotationPresent(Benchmark.class)) {
                                    long start = System.nanoTime();
                                    System.out.println("Benchmark started: " + start);


                                    Object result = method.invoke(bean, args);

                                    System.out.println("Benchmark finished: " + (System.nanoTime() - start));

                                    return result;
                                } else {
                                    return method.invoke(bean, args);
                                }
                            }
                        }
                );

                return proxy;
            }
        }

        return bean;

    }
}
