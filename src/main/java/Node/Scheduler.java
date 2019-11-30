package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;


public class Scheduler implements Observer, Runnable {

    @Override
    public void onObservableChanged(Node n) {
        if (n.checkAvailable()) {
            System.out.println("Scheduler is assigning a job to Node");
            JobQueue q = JobQueue.getSingletonInstance();
            AbstractJob J = (AbstractJob) q.remove();
            n.addJob(J);
        } else {
            System.out.println("Node is busy");
        }
    }

    @Override
    public void run() {

    }
}
