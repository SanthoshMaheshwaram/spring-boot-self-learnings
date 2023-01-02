/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AspectConfig {

    @Autowired
    HttpServletRequest request;

    private static final Logger logger = LoggerFactory.getLogger(AspectConfig.class);
    @Before(value = "execution(* org.jangaon.familyfriendsservice.controller..*(..))")
    public void beforeAdvice(JoinPoint joinPoint) { // ProceedingJoinPoint, is only supported for round robbin advise
        logger.info(String.format("Before method: %s", joinPoint.getSignature()));
        logger.info(String.format("test header received in request is :: %s", request.getHeader("test")));
    }

}


/*
execution(* com.abc.xyz..controller..*(..)) || --> this works for all method in all controller
execution(* com.abc.xyz..service..*(..)) ||
execution(* com.abc.xyz..dao..*(..))
@Before(value = "execution(* org.jangaon.familyfriendsservice.service.controller.UserController.*(..))") -->this works for one controller and all methods
in it
 */