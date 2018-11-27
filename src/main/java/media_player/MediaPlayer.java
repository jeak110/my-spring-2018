package media_player;


import lombok.Getter;
import lombok.Setter;
import media_player.qualifiers.DeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static media_player.qualifiers.DeviceType.Type.DISK;

@Component
public class MediaPlayer {

    @Setter
    @Getter
    @Autowired
    @DeviceType(DISK)
    private List<MediaDevice> mediaDevices;

    @PostConstruct
    public void init() {
        System.out.println("Initializing media player, media devices found");
        mediaDevices.forEach(e-> System.out.println(e.getClass().getName()));

        mediaDevices.forEach(MediaDevice::play);

    }



}
