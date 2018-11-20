package my.spring.demo;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFactory {
    private static ObjectFactory instance;
    private Map<Class, Class> map = new HashMap<>();

    private List<ObjectConfigurator> configurators = new ArrayList<>();

    public ObjectFactory() {
        map.put(Speaker.class, ConsoleSpeaker.class);
        map.put(Cleaner.class, CleanImpl.class);

        configurators.add(new InjectRandomIntObjectConfigurator());
        configurators.add(new InjectByTypeObjectConfigurator());
    }

    public static ObjectFactory getInstance() {
        return instance == null ? instance = new ObjectFactory() : instance;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<T> classToCreate = type;
        if (type.isInterface()) {
            classToCreate = map.get(type);
        }
        T t = (T) classToCreate.newInstance();

        configure(t);

        return t;
    }

    private <T> void configure(T t) {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t);
        }
    }

}
