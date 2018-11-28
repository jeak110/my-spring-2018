package media_player;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PlayExceptionAspect {

    @AfterThrowing(pointcut = "execution(* media_player..*.play(..))",
            throwing = "ex")
    public void onException(Exception ex) {

        System.out.println("Sending exception report to ServiceDesk: " + ex.getMessage());

    }


}
