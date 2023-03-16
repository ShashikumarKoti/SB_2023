package com.skoti.learning.controller;

import com.skoti.learning.service.LoggerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class Slf4jLoggerController {

    @Autowired
    private LoggerService loggerService;

    @GetMapping("/slf4j/loggers")
    public String getLoggers() {
        log.trace("This is TRACE from Slf4j");
        log.debug("This is DEBUG from Slf4j");
        log.info("This is INFO from Slf4j");
        log.warn("This is WARN from Slf4j");
        log.error("This is ERROR from Slf4j");
        loggerService.serviceLoggers();
        return "logs are shown in console from Slf4j controller";
    }
}
