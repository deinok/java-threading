package com.github.deinok.threding;

import com.github.deinok.threading.Task;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Callable;

public class TaskTests {

    @Test(timeout = 500)
    public void sleepTest() throws InterruptedException {
        Task<Void> task = new Task<Void>(new Callable<Void>() {
            @Override
            public Void call() throws InterruptedException {
                Thread.sleep(250);
                return null;
            }
        }).executeAsync();

        Thread.sleep(250);

        task.await();
    }

    @Test
    public void resultIntegerTest(){
        Task<Integer> task = new Task<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return 1;
            }
        }).executeAsync();
        Assert.assertEquals(1, (int)task.getResult());
    }
}
