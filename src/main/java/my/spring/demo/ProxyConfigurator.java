package my.spring.demo;

public interface ProxyConfigurator {
    <T> T wrapWithProxy(T t);
}
