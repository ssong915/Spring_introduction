package hello.hellospring.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component //스프링빈 등록
@Aspect //AOP라는 뜻
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    // 어디에 적용할건가?
    // hello.hellospring 에 있는거 다 적용해! 라는 뜻

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable
    {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed();

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}