package media_player;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OnlineDevice implements MediaDevice {

    @PostConstruct
    public void init() {
        System.out.println("INIT ONLINE DEVICE");
    }

    @Override
    public void play() {
        System.out.println("-------------- Playing Online -----------");

        OnlineChannels.channels.forEach(System.out::println);
    }
}
