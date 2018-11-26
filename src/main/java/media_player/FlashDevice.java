package media_player;

import com.google.common.collect.Lists;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FlashDevice implements MediaDevice {

    @Value("#{'${mediaFiles}'.split(',')}")
    private List<String> mediaFiles;


    @Override
    public void play() {
        System.out.println("-------------- Playing Flash -----------");
        mediaFiles.forEach(System.out::println);
    }
}
