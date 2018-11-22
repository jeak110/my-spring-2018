package media_player;

import com.google.common.collect.Lists;
import lombok.Setter;

import java.util.List;

public class CdDevice implements MediaDevice {

    @Setter
    private String title;

    @Setter
    private List<String> songs;


    @Override
    public void play() {
        System.out.println("-------------- Playing CD -----------");
        System.out.println("Title: " + title);
        songs.forEach(System.out::println);
    }
}
