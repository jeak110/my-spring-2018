package media_player;

import com.google.common.collect.Lists;
import lombok.Setter;
import media_player.qualifiers.DeviceType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static media_player.qualifiers.DeviceType.Type.DISK;
import static media_player.qualifiers.DeviceType.Type.FLASH;

@Component
@DeviceType(FLASH)
public class FlashDevice implements MediaDevice {

    @Value("#{'${mediaFiles}'.split(',')}")
    private List<String> mediaFiles;


    @Override
    public void play() {
        System.out.println("-------------- Playing Flash -----------");
        mediaFiles.forEach(System.out::println);
    }
}
