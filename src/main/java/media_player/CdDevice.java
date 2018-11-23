package media_player;

import lombok.Setter;


public class CdDevice implements MediaDevice {

    @Setter
    private Disk disk;

    @Setter
    private MediaPlayer mediaPlayer;

    public CdDevice() {
        System.out.println("CONSTRUCTOR: CD DEVICE");
    }

    public void init() {
        System.out.println("INIT: CD DEVICE");
    }

    @Override
    public void play() {
        System.out.println("-------------- Playing CD -----------");
        System.out.println("Title: " + disk.getTitle());
        disk.getSongs().forEach(System.out::println);
    }
}
