package test;

import java.util.concurrent.*;

/**
 * @program: LeetCode
 * @description: ThreadPoolExecutor
 * @author: Yukun Lee
 * @create: 2019-09-10 15:34
 */

public class TestThreadPool {

    public ExecutorService createThreadPool(){
        /**
         * int corePoolSize, // 正式工数量
         * int maximumPoolSize, // 工人数量上限，包括正式工和临时工
         * long keepAliveTime, TimeUnit unit, // 临时工游手好闲的最长时间，超过这个时间将被解雇
         * BlockingQueue<Runnable> workQueue, // 排期队列
         * ThreadFactory threadFactory, // 招人渠道
         * RejectedExecutionHandler handler) // 拒单方式
         */
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                5,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(512),
                //new SynchronousQueue<Runnable>(),
                new ThreadPoolExecutor.DiscardPolicy());

        ExecutorService pool1 = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
        ExecutorService pool2 = Executors.newFixedThreadPool(10, Executors.privilegedThreadFactory());


        for(int i=0;i<20;i++) {
            pool.execute(new ThreadTask());
            pool.submit(new ThreadTask());
            Thread t = new Thread();
        }
        return pool;
    }

    public class ThreadTask implements Runnable{

        public ThreadTask() {

        }

        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
