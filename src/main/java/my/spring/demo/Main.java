package my.spring.demo;

public class Main {
    public static void main(String[] args) {
        IRobot robot = ObjectFactory.getInstance().createObject(IRobot.class);
        robot.clean();
    }
}
