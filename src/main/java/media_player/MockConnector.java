package media_player;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("onlineConnector")
@Lazy
@Profile("test")
public class MockConnector {

    @PostConstruct
    public void init() {
        System.out.println("Mock connector...");

        OnlineChannels.channels = Lists.newArrayList(
                "Radio Mock",
                "Radio Test"
        );
    }

}
