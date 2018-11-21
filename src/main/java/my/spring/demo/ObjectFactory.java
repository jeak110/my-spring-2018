package my.spring.demo;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {
    private static ObjectFactory instance;
    private Reflections scanner;
    private Config config = JavaConfig.getInstance();
    private Context context = Context.getInstance();

    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory() {
        scanner = new Reflections(config.getPackagesToScan());

        for (Class<? extends ObjectConfigurator> configurator : scanner.getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(configurator.newInstance());
        }
        for (Class<? extends ProxyConfigurator> proxyConf : scanner.getSubTypesOf(ProxyConfigurator.class)) {
            proxyConfigurators.add(proxyConf.newInstance());
        }
    }

    public static ObjectFactory getInstance() {
        return instance == null ? instance = new ObjectFactory() : instance;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<T> classToCreate = JavaConfig.getInstance().getClassImpl(type);

        //
        if (classToCreate == null) {
            Set<Class<? extends T>> subTypes = scanner.getSubTypesOf(type);
            if (subTypes.size() == 0 || subTypes.size() > 1) {
                throw new RuntimeException("Zero or more than one implemention found of " + type.getName());
            }
            classToCreate = (Class<T>) subTypes.iterator().next();
        }
        //

        if (classToCreate.isAnnotationPresent(Singleton.class) && context.contains(type)) {
            return (T) context.get(type);
        }

        T t = (T) classToCreate.newInstance();

        configure(t);
        callPostConstruct(t);
        t = wrapWithProxyIfNeeded(t, classToCreate);

        if (classToCreate.isAnnotationPresent(Singleton.class) && !context.contains(type)) {
            context.put(type, t);
        }

        return t;
    }

    private <T> T wrapWithProxyIfNeeded(T t, Class<T> type) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = proxyConfigurator.wrapWithProxy(t, type);
        }
        return t;
    }

    @SneakyThrows
    private <T> void callPostConstruct(T t) {
        for (Method method : t.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t);
        }
    }

}
