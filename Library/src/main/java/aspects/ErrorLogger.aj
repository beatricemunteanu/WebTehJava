package aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ErrorLogger {
    private Logger logger = Logger.getLogger(ErrorLogger.class.getName());

    @AfterThrowing(value = "@annotation(ErrorBook)", throwing = "exception")
    public void borrowedError(Exception exception) throws Throwable {
        logger.info("ERROR: " +  exception.getMessage());
    }

}
