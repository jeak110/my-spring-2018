package my.spring.demo;

public class CleanImpl implements Cleaner {
    @InjectRandomInt(min = 2, max = 5)
    private Integer repeat;

    public void clean() {
        // 100500 lines of logic
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVvvvvvvvvv");
        }
    }
}
