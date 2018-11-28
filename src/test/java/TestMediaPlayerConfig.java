import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"media_player"})
@PropertySource("classpath:test-application.properties")
public class TestMediaPlayerConfig {
}
