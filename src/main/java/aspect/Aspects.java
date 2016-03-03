package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspects {

    @Around("@annotation(aspect.Time)")
    public Object consejoE(ProceedingJoinPoint pjp) throws Throwable {
    	long cont= System.currentTimeMillis();
        Object obj = pjp.proceed();
        long cont2=System.currentTimeMillis();
        System.out.println("=== Tirmpo transcurrido"+ (cont2-cont)+ " ms");
        return obj;
    }   
}
