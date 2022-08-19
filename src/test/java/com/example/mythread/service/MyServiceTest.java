package com.example.mythread.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
class MyServiceTest {

    private MyService myService = new MyService();


    @Test
    void field() throws InterruptedException {
        log.info("start");

        Runnable userA = () -> myService.logic("userA");
        Runnable userB = () -> myService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("Thread A");

        Thread threadB = new Thread(userB);
        threadB.setName("Thread B");

        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(3000);

        log.info("exit");
    }


}