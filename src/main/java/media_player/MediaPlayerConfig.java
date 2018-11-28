package media_player;

import org.springframework.context.annotation.*;

@Profile("prod")
@Configuration
@ComponentScan(basePackages = "media_player")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MediaPlayerConfig {
}
