package media_player;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MediaPlayer {

    @Setter
    @Getter
    private List<MediaDevice> mediaDevices;

    public void init() {
        System.out.println("Initializing media player, media devices found");
        mediaDevices.forEach(e-> System.out.println(e.getClass().getName()));

        mediaDevices.forEach(MediaDevice::play);

    }



}
