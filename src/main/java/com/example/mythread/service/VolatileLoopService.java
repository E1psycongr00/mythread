package com.example.mythread.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileLoopService {

    /**
     * Cache 를 이용하지 않고 직접 Main Memory에 접근할 수 있는 변수
     */
    private volatile int number;

    /**
     *  이 메서드는 외부에 어떤 작업에 의해서 number가 10에 도달해야 loop가 종료되는 메서드
     */
    public void task() {
        while (number < 10) {
            log.info("number: {}", number);
            sleep(20);
        }
    }

    public void addNumber() {
        this.number++;
        log.info("addedNumber: {}", number);
    }

    public int getNumber() {
        return number;
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
