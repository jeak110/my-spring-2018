package media_player;

import com.google.common.collect.Lists;
import lombok.Setter;

import java.util.List;

public class FlashDevice implements MediaDevice {

    @Setter
    private List<String> mediaFiles;


    @Override
    public void play() {
        System.out.println("-------------- Playing Flash -----------");
        mediaFiles.forEach(System.out::println);
    }
}
