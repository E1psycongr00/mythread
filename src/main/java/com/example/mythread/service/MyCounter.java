package com.example.mythread.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyCounter {

    private int cnt = 0;


    public void increase() {
        log.info("cnt: {}: cnt");
        this.cnt += 1;
        sleep(500);
    }

    public int getCnt() {
        return this.cnt;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
