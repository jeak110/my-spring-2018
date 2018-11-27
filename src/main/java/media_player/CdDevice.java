package media_player;

import lombok.Setter;
import media_player.bfpp.DeprecatedClass;
import media_player.bfpp.QuantumDevice;
import media_player.bpp.Benchmark;
import media_player.bpp.Shuffle;
import media_player.qualifiers.DeviceType;
import media_player.qualifiers.DiskType;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static media_player.qualifiers.DeviceType.Type.DISK;
import static media_player.qualifiers.DiskType.Type.CD;


//@DeprecatedClass(newClass = QuantumDevice.class)
@Component
@DeviceType(DISK)
//@Scope("prototype")
public class CdDevice implements MediaDevice {


//    private Disk disk;
    private ObjectFactory<Disk> diskFactory;

    @Benchmark
    public void init() {
        System.out.println("INIT CD DEVICE");
    }

    @Autowired
    @DiskType(CD)
    public void setDisk(ObjectFactory<Disk> diskFactory) {
        this.diskFactory = diskFactory;
//        this.disk = disk;
//        songsOrdered = disk.getSongs();
    }

//    @Shuffle
//    private List<String> songsOrdered;

    @Override
    @Benchmark
    public void play() {

        Disk disk = diskFactory.getObject();

        System.out.println("-------------- Playing CD -----------");
        System.out.println("Title: " + disk.getTitle());
        disk.getSongs().forEach(System.out::println);
    }
}
