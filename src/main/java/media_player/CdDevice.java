package media_player;

import lombok.Setter;
import media_player.bfpp.DeprecatedClass;
import media_player.bfpp.QuantumDevice;
import media_player.bpp.Benchmark;
import media_player.bpp.Shuffle;

import java.util.List;


@DeprecatedClass(newClass = QuantumDevice.class)
public class CdDevice implements MediaDevice {

    private Disk disk;

    @Benchmark
    public void init() {
        System.out.println("INIT CD DEVICE");
    }


    public void setDisk(Disk disk) {
        this.disk = disk;
        songsOrdered = disk.getSongs();
    }

    @Shuffle
    private List<String> songsOrdered;

    @Override
    @Benchmark
    public void play() {
        System.out.println("-------------- Playing CD -----------");
        System.out.println("Title: " + disk.getTitle());
        songsOrdered.forEach(System.out::println);
    }
}
