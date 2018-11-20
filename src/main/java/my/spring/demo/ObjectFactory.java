package my.spring.demo;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {
    private static ObjectFactory instance;
    private Reflections scanner;
    private Config config = JavaConfig.getInstance();

    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory() {
        scanner = new Reflections(config.getPackagesToScan());

        for (Class<? extends ObjectConfigurator> configurator : scanner.getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(configurator.newInstance());
        }
    }

    public static ObjectFactory getInstance() {
        return instance == null ? instance = new ObjectFactory() : instance;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        T t = getClassInstance(type);
        configure(t);
        callPostConstruct(t);

        return t;
    }

    private <T> void callPostConstruct(T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : t.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> T getClassInstance(Class<T> type) throws InstantiationException, IllegalAccessException {
        Class<T> classToCreate = JavaConfig.getInstance().getClassImpl(type);
        if (classToCreate == null) {
            Set<Class<? extends T>> subTypes = scanner.getSubTypesOf(type);
            if (subTypes.size() == 0 || subTypes.size() > 1) {
                throw new RuntimeException("Zero or more than one implemention found of " + type.getName());
            }
            classToCreate = (Class<T>) subTypes.iterator().next();
        }

        return (T) classToCreate.newInstance();
    }

    private <T> void configure(T t) {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t);
        }
    }

}
