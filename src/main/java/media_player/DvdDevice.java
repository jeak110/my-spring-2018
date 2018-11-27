package media_player;

import media_player.bpp.Benchmark;
import media_player.bpp.Shuffle;
import media_player.qualifiers.DeviceType;
import media_player.qualifiers.DiskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static media_player.qualifiers.DeviceType.Type.DISK;
import static media_player.qualifiers.DiskType.Type.DVD;


//@DeprecatedClass(newClass = QuantumDevice.class)
@Component
@DeviceType(DISK)
@Scope("prototype")
public class DvdDevice implements MediaDevice {


    private Disk disk;

    @Benchmark
    public void init() {
        System.out.println("INIT DVD DEVICE");
    }

    @Autowired
    @DiskType(DVD)
    public void setDisk(Disk disk) {
        this.disk = disk;
        songsOrdered = disk.getSongs();
    }

    @Shuffle
    private List<String> songsOrdered;

    @Override
    @Benchmark
    public void play() {
        System.out.println("-------------- Playing DVD -----------");
        System.out.println("Title: " + disk.getTitle());
        songsOrdered.forEach(System.out::println);
    }
}
