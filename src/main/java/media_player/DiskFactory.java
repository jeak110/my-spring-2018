package media_player;

import media_player.qualifiers.DiskType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static media_player.qualifiers.DiskType.Type.CD;
import static media_player.qualifiers.DiskType.Type.DVD;

@Configuration
public class DiskFactory {

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
    public Disk getCdDisk() throws Exception {
        System.out.println("Producing CD Disk ....");
        Disk disk = new Disk("CD: " + title, songs);
        return disk;
    }

    @Bean
    @DiskType(DVD)
    public Disk getDvdDisk() throws Exception {
        System.out.println("Producing DVD Disk ....");
        Disk disk = new Disk("DVD: " + title, songs);
        return disk;
    }

}
