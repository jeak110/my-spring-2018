package my.spring.demo;

public class ConsoleSpeaker implements Speaker {
    public void speak(String message) {
        System.out.println(message);
    }
}
