package com.imooc.pz.lambda.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueTest {

    @Test
    public void test() throws InterruptedException {
        /**
         * 基于数组的有界队列，队列容量为10
         */
        ArrayBlockingQueue<Integer> queue =
                new ArrayBlockingQueue<Integer>(10);
        //循环向队列添加值
        for(int i = 0; i<20; i++){
            queue.put(i);
            System.out.println("向队列中添加值" +i);
        }
    }


    @Test
    public void test2() throws InterruptedException {
        /**
         * 基于链表的有界队列，队列容量为10
         */
        LinkedBlockingQueue<Integer> queue =
                new LinkedBlockingQueue<Integer>(10);

        //循环向队列添加值
        for(int i = 0; i<20; i++){
            queue.put(i);
            System.out.println("向队列中添加值" +i);
        }
    }

    @Test
    public void test3() throws InterruptedException {
        /**
         * 基于链表的有界/无界队列
         */
        LinkedBlockingQueue<Integer> queue =
                new LinkedBlockingQueue<Integer>();

        //循环向队列添加值
        for(int i = 0; i<20; i++){
            queue.put(i);
            System.out.println("向队列中添加值" +i);
        }
    }

    @Test
    public void test4(){
        /**
         * 同步移交阻塞队列，没有存储元素的能力，元素的插入依托于元素的删除
         */
        SynchronousQueue<Integer> queue =
                new SynchronousQueue<>();

        //插入值
        new Thread(()->{
            try {
                queue.put(1);
                System.out.println("插入成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //删除值
        new Thread(()->{
            try {
                queue.take();
                System.out.println("删除成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
