package com.example.mythread.service;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MyService {

    private String store;

    public String logic(String name) {
        log.info("저장 name={}, store={}", name, store);
        this.store = name;
        sleep(1000);

        log.info("조회: store= {}", this.store);
        return store;
    }

    public String getStore() {
        return this.store;
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
