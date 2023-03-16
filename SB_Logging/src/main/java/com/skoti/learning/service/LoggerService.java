package com.skoti.learning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggerService {

    public void serviceLoggers() {
        log.trace("Service level TRACE");
        log.debug("Service level DEBUG");
        log.error("Service level ERROR");
    }
}
