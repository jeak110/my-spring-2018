package mocks;

import com.google.common.collect.Lists;
import media_player.OnlineChannels;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("onlineConnector")
@Lazy
@Profile("test")
public class MockConnector {

    @Value("${channels}")
    private String channel;

    @PostConstruct
    public void init() {
        System.out.println("Mock connector...");

        OnlineChannels.channels = Lists.newArrayList(channel);
    }

}
