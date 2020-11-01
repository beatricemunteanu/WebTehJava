package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public aspect ActionLogger {
    private Logger logger = Logger.getLogger(ActionLogger.class.getName());

    @Around("execution(* service.*.*(..))")
    public Object logAction(ProceedingJoinPoint joinPoint) throws Throwable {

        long start_tms = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("Before executing " + methodName + " with params: " + Arrays.asList(arguments));
        Object[] newArguments = {22};
        Object result = joinPoint.proceed(newArguments);
        logger.info("After executing " + methodName + " with params: " + Arrays.asList(newArguments));
        long end_tms = System.currentTimeMillis() - start_tms;
        logger.info("Execution time:  " + end_tms);

        return result;
    }
}
