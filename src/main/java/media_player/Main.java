package media_player;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("media_player");


        MediaPlayer mediaPlayer1 = context.getBean(MediaPlayer.class);
        mediaPlayer1.play();

        // by name
//        MediaDevice cdDevice = context.getBean("cdDevice", MediaDevice.class);
//        cdDevice.play();

        // by class type
        //CdDevice cdDevice = context.getBean(CdDevice.class);
        //cdDevice.play();

        // by interface type - Exception
//        MediaDevice cdDevice = context.getBean(MediaDevice.class);
//        cdDevice.play();

//        Map<String, MediaDevice> mediaDevices = context.getBeansOfType(MediaDevice.class);
//        mediaDevices.values().forEach(MediaDevice::play);
    }

}
