package media_player;

import lombok.Setter;


public class CdDevice implements MediaDevice {

    @Setter
    private Disk disk;

    @Override
    public void play() {
        System.out.println("-------------- Playing CD -----------");
        System.out.println("Title: " + disk.getTitle());
        disk.getSongs().forEach(System.out::println);
    }
}
