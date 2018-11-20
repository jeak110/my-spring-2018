package my.spring.demo;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PerformanceLogger {
    public void logStart(Method method) {
        String dateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
        System.out.println(method.getName() + " started at " + dateTime
            + " mem total = " + Runtime.getRuntime().totalMemory()
            + " / free mem = " + Runtime.getRuntime().freeMemory());
    }

    public void logEnd(Method method) {
        String dateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
        System.out.println(method.getName() + " ended at " + dateTime
                + " mem total = " + Runtime.getRuntime().totalMemory()
                + " / free mem = " + Runtime.getRuntime().freeMemory());
    }
}
