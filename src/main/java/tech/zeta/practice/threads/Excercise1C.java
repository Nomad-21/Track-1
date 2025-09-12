package tech.zeta.practice.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Excercise1C {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void one() {
        Runnable task = () -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locked resource1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked resource2");
                }
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        //By locking the resource in the same order deadlock in avoided.

        t1.start();
        t2.start();
    }

    private static void runTask(String name, ReentrantLock first, ReentrantLock second) {
        try {
            //By defining the time we are preventing threads from waiting indefinetly
            if (first.tryLock(500, TimeUnit.MILLISECONDS)) {
                System.out.println(name + " acquired " + first);
                Thread.sleep(100);
                if (second.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(name + " acquired " + second + " -> Doing work");
                        Thread.sleep(200);
                    } finally {
                        second.unlock();
                        System.out.println(name + " released " + second);
                    }
                } else {
                    System.out.println(name + " could not acquire " + second + " (timeout) -> backing off");
                }
                first.unlock();
                System.out.println(name + " released " + first);
            } else {
                System.out.println(name + " could not acquire " + first + " (timeout)");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void two() {
        ReentrantLock lock1 = new ReentrantLock(){
            @Override
            public String toString() {
                return "lock1";
            }
        };
        ReentrantLock lock2 = new ReentrantLock(){
            @Override
            public String toString() {
                return "lock2";
            }
        };

        Runnable task1 = () -> runTask("Thread-1", lock1, lock2);
        Runnable task2 = () -> runTask("Thread-2", lock2, lock1);

        new Thread(task1).start();
        new Thread(task2).start();
    }

    class BankAccount{
        private AtomicInteger balance;

        public int getBalance(){return balance.get();}

        public BankAccount(int intialAmount){
            this.balance = new AtomicInteger(intialAmount);
        }


        public  void deposit(int amount){
            if(amount<=0)   throw new IllegalArgumentException("Enter Valid amount");
            int temp = balance.addAndGet(amount);
            System.out.println("Amount after deposit: "+temp);
        }

        public void withdraw(int amount) {
            if (amount <= 0) throw new IllegalArgumentException("Enter valid amount");
            while (true) { //You keep trying to compare and set balance, if the balance is updated below the amount it throws the error
                int current = balance.get();
                if (amount > current) {
                    throw new IllegalArgumentException("Insufficient Funds "+current);
                }
                int updated = current - amount;
                if (balance.compareAndSet(current, updated)) {
                    System.out.println("Amount after withdrawal: "+updated);
                    break;
                }
            }
        }

    }

    public void three() throws  InterruptedException{
        BankAccount bankAccount = new BankAccount(100);

        Thread depositor = new Thread(()->{
            bankAccount.deposit(100);
            try{Thread.sleep(100);}
            catch (InterruptedException e){ e.printStackTrace();}
            bankAccount.deposit(1000);
        });

        Thread withdrawer = new Thread(()->{
            bankAccount.withdraw(90);
            try{Thread.sleep(1000);}
            catch (InterruptedException e){ e.printStackTrace();}
            bankAccount.withdraw(1000);
        });

        depositor.start();
        withdrawer.start();

        depositor.join();
        withdrawer.join();

        System.out.println("Final Bank Balance: "+bankAccount.getBalance());
    }

    public static void main(String[] args) throws InterruptedException {
        Excercise1C obj = new Excercise1C();

        //one();
        //two();
        obj.three();
    }
}
