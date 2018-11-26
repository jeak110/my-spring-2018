package media_player;

import lombok.Setter;
import media_player.bfpp.DeprecatedClass;
import media_player.bfpp.QuantumDevice;
import media_player.bpp.Benchmark;
import media_player.bpp.Shuffle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


//@DeprecatedClass(newClass = QuantumDevice.class)
@Component
public class CdDevice implements MediaDevice {


    private Disk disk;

    @Benchmark
    public void init() {
        System.out.println("INIT CD DEVICE");
    }

    @Autowired
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
