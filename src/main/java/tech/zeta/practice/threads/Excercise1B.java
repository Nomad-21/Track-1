package tech.zeta.practice.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Excercise1B {

    class BankAccount{
        private int balance=0;

        public int getBalance(){return balance;}

        public synchronized void deposit(int amount){
            if(amount<=0)   throw new IllegalArgumentException("Enter Valid amount");
            balance+=amount;
            System.out.println("Amount after deposit: "+balance);
        }

        public synchronized void withdraw(int amount){
            if(amount<=0)   throw new IllegalArgumentException("Enter Valid amount");
            if(amount>balance)   throw new IllegalArgumentException("Insufficient Funds");
            balance-=amount;
            System.out.println("Amount after withdraw: "+balance);
        }

    }

    public void one() throws  InterruptedException{
        BankAccount bankAccount = new BankAccount();

        Thread depositor = new Thread(()->{
            bankAccount.deposit(100);
            bankAccount.deposit(1000);
        });

        Thread withdrawer = new Thread(()->{
            bankAccount.withdraw(90);
            bankAccount.withdraw(1000);
        });

        depositor.start();
        withdrawer.start();

        depositor.join();
        withdrawer.join();

        System.out.println("Final Bank Balance: "+bankAccount.getBalance());
    }
    private static int count;
    private static void two() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);
        count = 0;
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                lock.lock();
                try {
                    count++;
                    System.out.println( Thread.currentThread().getName() +" incremented to " + count);
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final count = " + count + "\n");

        //By making it fair, it follows FCFS, else the same thread may grab the lock again and again.
    }

    private Random random = new Random();

    public void three() throws InterruptedException {

        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(()->{
            try {
               for(int turn=1;turn<=5;turn++){
                   int data = random.nextInt(100);
                   System.out.println(" Produced : "+data);
                   buffer.put(data);
                   Thread.sleep(100);
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(()->{
            try {
                for(int turn=1;turn<=5;turn++){
                    int data = buffer.take();
                    System.out.println("Consumed: "+data);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        consumer.start();
        producer.start();

        producer.join();
        consumer.join();
        System.out.println("Main thread completed");
    }

    public static void main(String[] args) throws InterruptedException {
        Excercise1B object = new Excercise1B();

        //object.one();
        //two();
        object.three();
    }
}
