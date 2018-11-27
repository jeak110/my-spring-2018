package media_player;

import lombok.Setter;
import media_player.bfpp.DeprecatedClass;
import media_player.bfpp.QuantumDevice;
import media_player.bpp.Benchmark;
import media_player.bpp.Shuffle;
import media_player.qualifiers.DeviceType;
import media_player.qualifiers.DiskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static media_player.qualifiers.DeviceType.Type.DISK;
import static media_player.qualifiers.DiskType.Type.CD;


//@DeprecatedClass(newClass = QuantumDevice.class)
@Component
@DeviceType(DISK)
public class CdDevice implements MediaDevice {


    private Disk disk;

    @Benchmark
    public void init() {
        System.out.println("INIT CD DEVICE");
    }

    @Autowired
    @DiskType(CD)
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
