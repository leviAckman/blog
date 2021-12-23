package com.levi.log.aspect;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private final Logger log=LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.levi.log.controller.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint jp){
        ServletRequestAttributes sra=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();
        String classMethod=jp.getSignature().getDeclaringTypeName()+"."+jp.getSignature().getName();
        Object[] args=jp.getArgs();
        ResultLog resultLog = new ResultLog(url,ip,classMethod,args);
        log.info("Result: {}",resultLog);
    }

    @After("pointcut()")
    public void after(){

    }

    @AfterReturning(returning = "result",pointcut="pointcut()")
    public void afterReturning(Object result){
        log.info("Result:{}",result);
    }

    private class ResultLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public ResultLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "ResultLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
