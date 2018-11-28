import media_player.*;
import media_player.qualifiers.DeviceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static media_player.qualifiers.DeviceType.Type.DISK;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = TestMediaPlayerConfig.class)
public class TestConnector {

    @Autowired
    OnlineDevice onlineDevice;

    @Test
    public void test1() {
        assertEquals("Radio Test", OnlineChannels.channels.get(0));
    }


}
