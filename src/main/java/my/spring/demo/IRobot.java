package my.spring.demo;

import javax.annotation.PostConstruct;

@LogPerformance
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void init() {
        speaker.speak(cleaner.getName());
    }

    public void clean() {
        speaker.speak("Начал работу");
        cleaner.clean();
        speaker.speak("Закончил работу");
    }
}
