package media_player;


import lombok.Getter;
import lombok.Setter;
import media_player.qualifiers.DeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static media_player.qualifiers.DeviceType.Type.DISK;

@Component
//@Scope("prototype")
public class MediaPlayer {

    @Setter
    @Getter
    @Autowired
    private List<MediaDevice> mediaDevices;

//    @Autowired(required = false)
//    @Lazy
//    private OnlineDevice onlineDevice;

    //@PostConstruct
    public void play() {
        System.out.println("Initializing media player, media devices found");
        mediaDevices.forEach(e-> System.out.println(e.getClass().getName()));

        mediaDevices.forEach(MediaDevice::play);

//        if (onlineDevice != null) {
//            onlineDevice.play();
//        }

    }



}
