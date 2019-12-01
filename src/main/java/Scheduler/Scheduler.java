package main.java.Scheduler;

import main.java.Jobs.AbstractJob;
import main.java.Node.Node;
import main.java.Node.Observer;
import main.java.SingletonJobQueue.JobQueue;

import java.util.NoSuchElementException;


public class Scheduler extends Thread implements Observer {

    @Override
    public synchronized void onObservableChanged(Node n) throws NoSuchElementException {
        JobQueue q = JobQueue.getSingletonInstance();
        try {
            if (n.checkAvailable() ) {
                System.out.println("Scheduler is assigning a job to Node");

                AbstractJob J = (AbstractJob) q.remove();
                System.out.println(q.size());
                n.addJob(J);
            }
        }
        catch(NoSuchElementException e) {
            System.out.println("Priorty q is empty");
            this.interrupt();
        }
    }


}
