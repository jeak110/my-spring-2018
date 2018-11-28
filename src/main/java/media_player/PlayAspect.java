package media_player;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PlayAspect {

    @Before("execution(* media_player..*.play(..))")
    public void before(JoinPoint jp) {
        System.out.println("Aspect is working!!!");
    }

}
