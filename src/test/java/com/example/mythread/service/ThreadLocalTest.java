package com.example.mythread.service;


import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    private ThreadLocalContext threadLocalContext = new ThreadLocalContext();

    @Test
    void ThreadLocalTest() throws InterruptedException {

        Runnable task1 = ()-> threadLocalContext.run(10);
        Runnable task2 = ()-> threadLocalContext.run(20);
        Thread threadA = new Thread(task1, "Thread A");
        Thread threadB = new Thread(task2, "Thread B");

        threadA.start();
        threadB.start();

        Thread.sleep(200);

    }
}
