package tech.zeta.practice.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Excercise1D {

    public class Tasks implements Runnable,Comparable<Tasks>{
        /* we are implementing Runnable, because
            - For using callable, we use .submit() which wraps the callable in FutureTask , this overrides our compareTo method
            - This cause an exception while comparing
            - So, we use .execute which takes Runnable .
        */
        private int priority;

        public Tasks(int priority){
            this.priority = priority;
        }
        int getPriority(){ return priority; }

        @Override
        public void run() {
            System.out.println("Task with Priority "+priority+" is executing....");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }

        @Override
        public int compareTo(Tasks o) {
            return o.getPriority() - priority;
        }
    }

    public void one() throws ExecutionException, InterruptedException {

        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,3,0,TimeUnit.SECONDS,queue);

        for(int count=0;count<5;count++)  threadPoolExecutor.execute(new Tasks(count));

        threadPoolExecutor.shutdown();
    }

    private static Random random = new Random();
    static int count=0;
    public static void two() throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,10,TimeUnit.SECONDS, new LinkedBlockingDeque<>(5));

        Runnable monitor = ()->{
            while (!threadPoolExecutor.isTerminated()) {
                System.out.printf("Pool Size: %d | Active Threads: %d | Queue Size: %d%n",
                        threadPoolExecutor.getPoolSize(),
                        threadPoolExecutor.getActiveCount(),
                        threadPoolExecutor.getQueue().size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        };

        new Thread(monitor).start();

        for(int thread=0; thread<10; thread++)
            threadPoolExecutor.execute(
                    ()->{ try {
                            int executionTime = 1000*random.nextInt(10);
                            System.out.printf("Thread-%d is executing for %d seconds%n",count,executionTime/1000);
                            count++;
                            Thread.sleep(executionTime);
                        }catch(InterruptedException exception){
                            exception.printStackTrace();
                        };
                    });


        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES);
    }


    public static void three() throws InterruptedException {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.scheduleAtFixedRate(()-> System.out.println(System.currentTimeMillis()),0,5,TimeUnit.SECONDS);


        Thread.sleep(30000);
        executorService.shutdown();
        executorService.awaitTermination(5,TimeUnit.SECONDS);
        System.out.println("Periodic execution of thread is finished");
    }

    public static void main(String[] args) throws Exception{
        Excercise1D object = new Excercise1D();
        //object.one();
        //two();
        three();
    }
}
