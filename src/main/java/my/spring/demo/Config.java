package my.spring.demo;

import java.util.List;

public interface Config {
    <T> Class<T> getClassImpl(Class<T> t);
    List<String> getPackagesToScan();
}
