package main.java.SingletonJobQueue;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.Node.Observer_o;

public class JobQueue<J> extends PriorityQueue<J> implements Runnable {
    AbstractJobFactory abstractJobFactory;
    //AbstractJob abstractJob=abstractJobFactory.getJob(15)
    private static JobQueue<AbstractJob> instance;
    static final int MAXQUEUE = 5;
    public JobQueue(AbstractJobFactory abstractJobFactory) {
        this.abstractJobFactory = abstractJobFactory;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                AbstractJob jobs = this.abstractJobFactory.getJob(10);
                System.out.println("Got message: " + jobs.getMessage());
                //sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {


        AbstractJobFactory abstractJobFactory = new FindMaxJobFactory();
        AbstractJob job = abstractJobFactory.getJob(15);
        Thread t1 = new Thread(job);
        t1.start();
        try {
            job.putMessage();
            job.putMessage();
            job.getMessage();
            job.getMessage();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    //    AbstractJob item;
//    static Semaphore semCon = new Semaphore(0);
//    static Semaphore semProd = new Semaphore(1);

//    public void get()
//    {
//        try {
//            // Before consumer can consume an item,
//            // it must acquire a permit from semCon
//            semCon.acquire();
//        }
//        catch (InterruptedException e) {
//            System.out.println("InterruptedException caught");
//        }
//
//        // consumer consuming an item
//        System.out.println("Consumer consumed item : " + item);
//
//        // After consumer consumes the item,
//        // it releases semProd to notify producer
//        semProd.release();
//    }
//
//    public void put(AbstractJob job)
//    {
//        try {
//            // Before producer can produce an item,
//            // it must acquire a permit from semProd
//            semProd.acquire();
//        }
//        catch (InterruptedException e) {
//            System.out.println("InterruptedException caught");
//        }
//
//        // producer producing an item
//        this.item = item;
//
//        System.out.println("Producer produced item : " + item);
//
//        // After producer produces the item,
//        // it releases semCon to notify consumer
//        semCon.release();
//    }


    private JobQueue() {
        //constructor
    }

    synchronized public static JobQueue getInstance() {
        if (instance == null) {
            instance = new JobQueue();
        }

        return instance;
    }


//    @Override
//    public void update(AbstractJob job) {

//    }
}

