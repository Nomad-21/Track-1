package tech.zeta.practice.threads;

public class Excercise1A {

    class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("Thread is running..");

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.println("Thread finished");
        }
    }
    MyThread thread1 = new MyThread();
    Runnable runnable = ()->{
        System.out.println("Runnable is running..");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("Runnable finished");
    };

    public void one(){
        thread1.start();
        new Thread(runnable).start();
    }

    public void two(){
        Thread thread2 = new  Thread(runnable);
        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
        }

    }

    public void three() {

        Thread thread1 = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Worker thread is running...");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Worker thread interrupted during sleep!");
            }
            System.out.println("Worker thread terminating...");
        });

        thread1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        System.out.println("Main thread interrupting Worker...");
        thread1.interrupt();

        try {
            thread1.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Worker thread has terminated. Main thread ending.");

        //The priority does not guarantee that the thread will run first
    }

    private int  counter = 0;
    public void four() throws InterruptedException {

        Runnable runnable = ()->{
            System.out.println(Thread.currentThread().getName()+" Priority: "+Thread.currentThread().getPriority());
            for(int count=0; count<=1000; count++){
                counter += count;
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Counter value of execution of threads: "+counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Excercise1A obj = new Excercise1A();

        //obj.one();
        //obj.two();
        //obj.three();
        obj.four();
    }
}
