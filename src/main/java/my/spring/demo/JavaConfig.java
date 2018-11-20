package my.spring.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class JavaConfig implements Config {
    private Map<Class, Class> map = new HashMap<>();
    private static JavaConfig instance;

    public static JavaConfig getInstance() {
        return instance == null ? instance = new JavaConfig() : instance;
    }

    public JavaConfig() {
        map.put(Speaker.class, ConsoleSpeaker.class);
    }

    @Override
    public <T> Class<T> getClassImpl(Class<T> type) {
        Class<T> classToCreate = type;
        if (type.isInterface()) {
            classToCreate = map.get(type);
        }
        return classToCreate;
    }

    @Override
    public List<String> getPackagesToScan() {
        return asList("my.spring.demo");
    }
}
