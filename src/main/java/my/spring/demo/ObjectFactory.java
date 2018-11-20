package my.spring.demo;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

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

        return t;
    }

    private <T> T getClassInstance(Class<T> type) throws InstantiationException, IllegalAccessException {
        Class<T> classToCreate = JavaConfig.getInstance().getClassImpl(type);
        return (T) classToCreate.newInstance();
    }

    private <T> void configure(T t) {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t);
        }
    }

}
