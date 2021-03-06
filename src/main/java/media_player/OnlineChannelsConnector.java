package media_player;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("onlineConnector")
@Lazy
@Profile("prod")
public class OnlineChannelsConnector {

    @PostConstruct
    public void init() {
        System.out.println("Establishing online channels...");

        OnlineChannels.channels = Lists.newArrayList(
                "Radio Jazz",
                "Retro FM"
        );
    }

}
