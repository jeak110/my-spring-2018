package media_player;

import com.google.common.collect.Lists;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FlashDevice implements MediaDevice {

    @Setter
    private List<String> mediaFiles = Lists.newArrayList(
            "StarWars.avi",
                "Terminator.mov"

    )
            ;


    @Override
    public void play() {
        System.out.println("-------------- Playing Flash -----------");
        mediaFiles.forEach(System.out::println);
    }
}
