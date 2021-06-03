package com.spring.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogAdvice {

    public void printLog() {
        log.info("############ LogAdvice::printLog ############");
    }
}
