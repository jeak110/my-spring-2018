package media_player;

import media_player.qualifiers.DiskType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static media_player.qualifiers.DiskType.Type.CD;
import static media_player.qualifiers.DiskType.Type.DVD;

@Configuration
public class DiskFactory {

    private int cdCounter = 1;

    private int dvdCounter = 1;

    @Value("${title}")
    private String title;

    @Value("#{'${songs}'.split(',')}")
    private List<String> songs;
//
//    public DiskFactory(String title, List<String> songs) {
//        this.title = title;
//        this.songs = songs;
//    }

    @Bean
    @DiskType(CD)
    @Scope("prototype")
    public Disk getCdDisk() throws Exception {
        System.out.println("Producing CD Disk .... " + cdCounter++);
        Disk disk = new Disk("CD: " + title, songs);
        return disk;
    }

    @Bean
    @DiskType(DVD)
    @Scope("prototype")
    public Disk getDvdDisk() throws Exception {
        System.out.println("Producing DVD Disk .... " + dvdCounter++);
        Disk disk = new Disk("DVD: " + title, songs);
        return disk;
    }

}
