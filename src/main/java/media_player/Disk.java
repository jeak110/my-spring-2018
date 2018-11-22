package media_player;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Disk {

    public Disk(String title, List<String> songs) {
        this.title = title;
        this.songs = songs;
    }

    private String title;

    private List<String> songs;
}
