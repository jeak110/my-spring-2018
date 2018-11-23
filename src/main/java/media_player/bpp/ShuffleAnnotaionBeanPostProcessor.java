package media_player.bpp;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class ShuffleAnnotaionBeanPostProcessor implements BeanPostProcessor {
    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

//        System.out.println("ShuffleAnnotaionBeanPostProcessor is working!!!!");

        Class<?> beanClass = bean.getClass();

        Field[] fields = beanClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Shuffle.class)) {

                field.setAccessible(true);

                Collections.shuffle((List)field.get(bean));
            }
        }

        return bean;
    }
}
