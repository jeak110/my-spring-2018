package media_player;

import com.google.common.collect.Lists;

import java.util.List;

public class CdDevice implements MediaDevice {

    private String title = "Queen";
    private List<String> songs = Lists.newArrayList(
            "1. Show must go on",
            "2. We will rock you",
            "3. Bycicle"
    );


    @Override
    public void play() {
        System.out.println("-------------- Playing CD -----------");
        System.out.println("Title: " + title);
        songs.forEach(System.out::println);
    }
}
