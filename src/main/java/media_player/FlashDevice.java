package media_player;

import com.google.common.collect.Lists;

import java.util.List;

public class FlashDevice implements MediaDevice {

    private List<String> mediaFiles = Lists.newArrayList(
            "StarWars.avi",
            "Terminator.mov"
    );


    @Override
    public void play() {
        System.out.println("-------------- Playing Flash -----------");
        mediaFiles.forEach(System.out::println);
    }
}
