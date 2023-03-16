package com.skoti.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/api")
public class LoggingController {

    public static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/loggers")
    public String getLoggers() {
        logger.trace("This is trace");
        logger.debug("This is debug");
        logger.info("This is info");
        logger.warn("This is warn");
        logger.error("This is error");
        return "Loggers are shown in console";
    }


}
