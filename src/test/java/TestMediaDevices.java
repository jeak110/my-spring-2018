import media_player.FlashDevice;
import media_player.MediaDevice;
import media_player.MediaPlayerConfig;
import media_player.qualifiers.DeviceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static media_player.qualifiers.DeviceType.Type.DISK;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MediaPlayerConfig.class)
public class TestMediaDevices {

    @DeviceType(DISK)
    @Autowired
    List<MediaDevice> mediaDevices;

    @Autowired
    private ApplicationContext context;

    @Test
    public void test1() {
        assertEquals(2, mediaDevices.size());
    }

    @Test
    public void test2() {
        FlashDevice flashDevice = context.getBean(FlashDevice.class);
        flashDevice.play();
    }

}
