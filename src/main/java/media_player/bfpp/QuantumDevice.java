package media_player.bfpp;

import lombok.Setter;
import media_player.Disk;
import media_player.MediaDevice;

public class QuantumDevice implements MediaDevice {
    @Override
    public void play() {
        System.out.println("NEW QUANTUM DEVICE IS PLAYING!");
    }

    public void init() {

    }

    @Setter
    private Disk disk;
}
