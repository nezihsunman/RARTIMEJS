package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import java.util.concurrent.Semaphore;

public class Scheduler implements Observer {

    @Override
    public void onObservableChanged(Node n) {
        if (n.getNodeStatus() == "Available") {
            System.out.println("give me a job pls");
            JobQueue q = JobQueue.getSingletonInstance();
            AbstractJob J = (AbstractJob) q.remove();
            n.addJob(J);
        }

        else {
            System.out.println("Node is busy");
        }


    }
}
//public class Scheduler implements Runnable, Observer {
//    static Semaphore semCon = new Semaphore(0);
//    static Semaphore semProd = new Semaphore(1);
//
//    JobQueue q = JobQueue.getInstance();
//
//    public Scheduler (Node n) {
//        n.registerObserver(this);
//    }
//
//    void assignJob(Node n)
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
//        AbstractJob J = (AbstractJob) q.remove();
//        n.fixedList.add(J);
//        System.out.println("Status of node: " + n.getStatus());
////        item.setStatus(true);
////        System.out.println("Consumer consumed item : " + item.toString());
//
//        // After consumer consumes the item,
//        // it releases semProd to notify producer
//        semProd.release();
//    }
//
//    // to put an item in buffer
//    @Override
//    public void run()
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
////        this.item = item;
////        assignJob(n);
////        update(n, n.getStatus());
//
//        System.out.println("Producer produced item : ");
//
//        // After producer produces the item,
//        // it releases semCon to notify consumer
//        semCon.release();
//    }
//
//    public void update(Node node, String status) {
//        System.out.println("update called");
//        node.setStatus(status);
//
//    }
//
//}
