package media_player;

import lombok.Setter;
import media_player.bpp.Shuffle;

import java.util.List;


public class CdDevice implements MediaDevice {

    private Disk disk;

    public void setDisk(Disk disk) {
        this.disk = disk;
        songsOrdered = disk.getSongs();
    }

    @Shuffle
    private List<String> songsOrdered;

    @Override
    public void play() {
        System.out.println("-------------- Playing CD -----------");
        System.out.println("Title: " + disk.getTitle());
        songsOrdered.forEach(System.out::println);
    }
}
