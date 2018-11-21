package my.spring.demo;

@Singleton
public class CleanImpl implements Cleaner {
    @InjectRandomInt(min = 2, max = 5)
    private Integer repeat;

    public void clean() {
        // 100500 lines of logic
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVvvvvvvvvv");
        }
    }

    @Override
    public String getName() {
        return "Repeat cleaner v.0.0."+repeat;
    }
}
