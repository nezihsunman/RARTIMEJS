package main.java.Scheduler;

import main.java.Jobs.AbstractJob;
import main.java.Node.Node;
import main.java.Node.Observer;
import main.java.SingletonJobQueue.JobQueue;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Scheduler extends Thread implements Observer {
    //Therad 2
    static boolean isNodeFull = true;
    static ArrayList<AbstractJob> scheduler = new ArrayList<AbstractJob>();

    @Override
    public synchronized void onObservableChanged(Node n) throws NoSuchElementException, InterruptedException {
        changeSetIsNodeFull(n);
        addJobToNode(n);
    }

    //Thread wil call this function
    public synchronized void popFromQue() throws InterruptedException {

        JobQueue q = JobQueue.getSingletonInstance();
        while (q.isEmpty()) {
            wait(5000);
            System.out.println(q.isEmpty());

        }
        System.out.println(q.isEmpty());
        this.scheduler.add((AbstractJob) q.remove());
    }

    public synchronized void addJobToNode(Node n) throws InterruptedException {
        JobQueue q = JobQueue.getSingletonInstance();

        if (n.checkAvailable()) {
            while (this.scheduler.size() == 0) {
                wait(2000);
                System.out.println("Waiting for popFromQue thread");
            }
            // Todo: Scheduler algorithm can call from there
            n.addJob(scheduler.remove(0));
            System.out.println("Que " + q.size());


        } else {
            System.out.println("-----------------node full");
        }


    }

    public synchronized void changeSetIsNodeFull(Node n) {
        if (n.checkAvailable()) {
            isNodeFull = false;
        } else {
            isNodeFull = true;

        }
    }
}