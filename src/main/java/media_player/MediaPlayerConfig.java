package media_player;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("prod")
@Configuration
@ComponentScan(basePackages = "media_player")
@PropertySource("classpath:application.properties")
public class MediaPlayerConfig {
}
