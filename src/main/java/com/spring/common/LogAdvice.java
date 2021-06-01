package com.spring.common;

import lombok.extern.log4j.Log4j;

@Log4j
public class LogAdvice {

    public void printLog() {
        log.info("############ LogAdvice::printLog ############ LogAdvice::printLog");
    }
}
