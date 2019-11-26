package main.java.SingletonJobQueue;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

import main.java.Jobs.AbstractJob;
import main.java.Node.Observer_o;

public class JobQueue<J> extends PriorityQueue<J> {

    private static JobQueue<AbstractJob> instance;
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

