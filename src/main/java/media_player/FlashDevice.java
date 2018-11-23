package media_player;

import com.google.common.collect.Lists;
import lombok.Setter;

import java.util.List;

public class FlashDevice implements MediaDevice {

    @Setter
    private List<String> mediaFiles;

    public FlashDevice() {
        System.out.println("CONSTRUCTOR: FLASH DEVICE");
    }

    public void init() {
        System.out.println("INIT: FLASH DEVICE");
    }

    @Override
    public void play() {
        System.out.println("-------------- Playing Flash -----------");
        mediaFiles.forEach(System.out::println);
    }
}
