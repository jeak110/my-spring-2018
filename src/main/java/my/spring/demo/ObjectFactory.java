package my.spring.demo;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private static ObjectFactory instance;
    private Map<Class, Class> map = new HashMap<>();

    public ObjectFactory() {
        map.put(Speaker.class, ConsoleSpeaker.class);
        map.put(Cleaner.class, CleanImpl.class);
    }

    public static ObjectFactory getInstance() {
        return instance == null ? instance = new ObjectFactory() : instance;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (!type.isInterface()) {
            return type.newInstance();
        }
        return (T) map.get(type).newInstance();
    }

}
