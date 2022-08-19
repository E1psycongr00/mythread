package com.example.mythread.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class VolatileTest {

    private LoopService loopService = new LoopService();
    private VolatileLoopService volatileLoopService = new VolatileLoopService();

    @Test
    public void LoopServiceTest() throws InterruptedException {
        Runnable task1 = () -> loopService.task();
        Runnable task2 = () -> loopService.addNumber();

        Thread threadA = new Thread(task1, "Thread A");

        threadA.start();

        Thread.sleep(100);
        for (int i = 0; i < 1000; ++i) {
            loopService.addNumber();
        }

        Thread.sleep(300);
        log.info("final number: {}", loopService.getNumber());
    }

    @Test
    public void VolatileLoopServiceTest() throws InterruptedException {
        Runnable task1 = () -> volatileLoopService.task();
        Runnable task2 = () -> volatileLoopService.addNumber();

        Thread threadA = new Thread(task1, "Thread A");
        Thread threadB = new Thread(task2, "Thread B");
        Thread threadC = new Thread(task2, "Thread C");
        Thread threadD = new Thread(task2, "Thread D");
        Thread threadE = new Thread(task2, "Thread E");

        threadA.start();

        Thread.sleep(100);



        threadB.start();
        Thread.sleep(50);
        threadC.start();
        Thread.sleep(50);
        threadD.start();
        Thread.sleep(50);
        threadE.start();
        Thread.sleep(50);


        Thread.sleep(300);
        log.info("final number: {}", volatileLoopService.getNumber());
    }
}
