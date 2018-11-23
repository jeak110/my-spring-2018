package media_player.bfpp;

import media_player.MediaDevice;

public class QuantumDevice implements MediaDevice {
    @Override
    public void play() {
        System.out.println("NEW QUANTUM DEVICE IS PLAYING!");
    }
}
