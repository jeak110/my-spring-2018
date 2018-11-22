package media_player;

public class MediaPlayer {

    private static MediaDevice flashDevice = new FlashDevice();
    private static MediaDevice cdDevice = new CdDevice();

    public static void main(String[] args) {

        cdDevice.play();
        flashDevice.play();
    }

}
