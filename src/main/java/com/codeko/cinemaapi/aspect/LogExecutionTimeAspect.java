package com.codeko.cinemaapi.aspect;

import com.codeko.cinemaapi.annotation.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

@Aspect
@Component
@Slf4j
public class LogExecutionTimeAspect {

    @Around("@annotation(annotation)")
    public Object perform(ProceedingJoinPoint point, LogExecutionTime annotation) throws Throwable {
        StopWatch stopWatch = new StopWatch(annotation.id());
        stopWatch.start(StringUtils.isEmpty(annotation.name()) ? point.getSignature().getName() : annotation.name());
        Object proceed = null;
        try {
            proceed = point.proceed();
            return proceed;
        } finally {
            stopWatch.stop();
            String message = annotation.pretty() ? stopWatch.shortSummary() : String.format("StopWatch id: [%s], name: [%s], Used Time: [%f] seconds", stopWatch.getId(), stopWatch.getLastTaskName(), stopWatch.getTotalTimeSeconds());
            log.info(message);
        }

    }
}
