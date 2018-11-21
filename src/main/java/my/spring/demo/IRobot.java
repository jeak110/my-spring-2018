package my.spring.demo;

import javax.annotation.PostConstruct;

public class IRobot {
    private ObjectFactory objectFactory = ObjectFactory.getInstance();

    @PostConstruct
    public void init() {
        Speaker speaker = objectFactory.createObject(Speaker.class);
        Cleaner cleaner = objectFactory.createObject(Cleaner.class);
        speaker.speak(cleaner.getName());
    }

    public void clean() {
        Speaker speaker = objectFactory.createObject(Speaker.class);
        speaker.speak("Начал работу");

        Cleaner cleaner = objectFactory.createObject(Cleaner.class);
        cleaner.clean();

        Speaker speaker1 = objectFactory.createObject(Speaker.class);
        speaker1.speak("Закончил работу");
    }
}
