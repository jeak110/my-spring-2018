package my.spring.demo;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

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
        T t = (T) map.get(type).newInstance();

        //
        for (Field field : t.getClass().getDeclaredFields()) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                field.setAccessible(true);
                field.set(t, ThreadLocalRandom.current().nextInt(annotation.min(), annotation.max()));
            }
        }

        return t;
    }

}
