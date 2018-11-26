package media_player;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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

    @Bean("queenDisk")
    public Disk getDisk() throws Exception {
        System.out.println("Producing Disk ....");
        Disk disk = new Disk(title, songs);
        return disk;
    }

}
