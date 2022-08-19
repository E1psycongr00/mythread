package com.example.mythread.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalContext {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public void run(int x) {
        threadLocal.set(x);
        log.info("threadLocal에 {} 쓰기 완료!!", x);
        sleep();
        Integer s = threadLocal.get();
        log.info("{}", s);

        threadLocal.remove();
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
