package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;


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
