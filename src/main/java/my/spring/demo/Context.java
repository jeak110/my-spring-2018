package my.spring.demo;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<Class, Object> map = new HashMap();
    private static Context instance;
    public static Context getInstance() {
        return instance == null ? instance = new Context() : instance;
    }
    
    public Object get(Class type) {
        return map.get(type);
    }
    
    public void put(Class type, Object t) {
        map.putIfAbsent(type, t);
    }
    
    public boolean contains(Class type) {
        return map.containsKey(type);
    }
}

