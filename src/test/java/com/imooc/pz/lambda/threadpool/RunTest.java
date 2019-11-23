package com.imooc.pz.lambda.threadpool;


import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunTest {

    @Test
   public  void submitTest() throws ExecutionException, InterruptedException {
        /**
         * 创建线程池
         */
       ExecutorService pool =
               Executors.newCachedThreadPool();

        /**
         * 利用submit方法提交任务，接受任务的返回结果
         */
        Future<Integer> submit = pool.submit(() -> {
            Thread.sleep(1000L * 10);//睡眠10秒
            return 2 * 5;
        });

        //阻塞方法，直到任务有返回值后，才向下执行
        Integer integer = submit.get();
        System.out.println("执行结果"+integer);
    }

    @Test
    public void executTest() throws InterruptedException {
        /**
         * 创建线程池
         */
        ExecutorService pool =
                Executors.newCachedThreadPool();

        /**
         * 利用execute方法提交任务，没有返回结果
         */
        pool.execute(()->{
            try {
                Thread.sleep(1000L* 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer num = 2 * 4;
            System.out.println(num);
        });

        Thread.sleep(1000L * 1000);
    }

}
