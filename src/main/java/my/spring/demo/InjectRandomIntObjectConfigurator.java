package my.spring.demo;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class InjectRandomIntObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                field.setAccessible(true);
                field.set(t, ThreadLocalRandom.current().nextInt(annotation.min(), annotation.max()));
            }
        }
    }
}
