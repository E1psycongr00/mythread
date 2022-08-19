package com.example.mythread.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
class MyCounterTest {
    private SynchronizedMyCounter synchronizedMyCounter = new SynchronizedMyCounter();

    @Test
    void FixedThreadPoolTest() throws InterruptedException {
        int numberOfTask = 50;
        MyCounter myCounter = new MyCounter();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(numberOfTask);

        for (int i = 0; i < numberOfTask; ++i) {
            executorService.submit(() -> {
                myCounter.increase();
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        log.info("myCounter: {}", myCounter.getCnt());
    }

    @Test
    void CachedThreadPoolTest() throws InterruptedException {
        int numberOfTask = 50;
        MyCounter myCounter = new MyCounter();

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(numberOfTask);

        for (int i = 0; i < numberOfTask; ++i) {
            executorService.submit(() -> {
                myCounter.increase();
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        log.info("myCounter: {}", myCounter.getCnt());
    }

    @Test
    void syncTest() throws InterruptedException {

        int numberOfTask = 1150;

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(numberOfTask);

        Runnable task1 = () -> {
            synchronizedMyCounter.increase();
            countDownLatch.countDown();
        };

        Runnable task2 = () -> {
            synchronizedMyCounter.decrease();
            countDownLatch.countDown();
        };



        for (int i = 0; i < numberOfTask; ++i) {
            executorService.submit(task1);
            executorService.submit(task2);
        }
        countDownLatch.await();
        assertThat(synchronizedMyCounter.getCnt()).isEqualTo(0);
    }
}