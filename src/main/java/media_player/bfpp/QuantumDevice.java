package media_player.bfpp;

import lombok.Setter;
import media_player.Disk;
import media_player.MediaDevice;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("research")
public class QuantumDevice implements MediaDevice {
    @Override
    public void play() {
        System.out.println("NEW QUANTUM DEVICE IS PLAYING!");
    }

    public void init() {
        System.out.println("INIT QUANTUM DEVICE");
    }

    @Setter
    private Disk disk;
}
