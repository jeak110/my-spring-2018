package my.spring.demo;

public class IRobot {
    private Speaker speaker = new ConsoleSpeaker();
    private Cleaner cleaner = new CleanImpl();

    public void clean() {
        speaker.speak("Начал работу");
        cleaner.clean();
        speaker.speak("Закончил работу");
    }
}
