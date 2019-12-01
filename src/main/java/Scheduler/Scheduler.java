package main.java.Scheduler;

import main.java.Jobs.AbstractJob;
import main.java.Node.Node;
import main.java.Node.Observer;
import main.java.SingletonJobQueue.JobQueue;

import java.util.NoSuchElementException;


public class Scheduler extends Thread implements Observer {

    @Override
    public synchronized void onObservableChanged(Node n) throws NoSuchElementException, InterruptedException {
        JobQueue q = JobQueue.getSingletonInstance();

        if (n.checkAvailable()) {
            System.out.println("Scheduler is assigning a job to Node");

            while (q.isEmpty()) {
                wait(5000);

            }
            System.out.println(q.isEmpty());
            AbstractJob J = (AbstractJob) q.remove();
            n.addJob(J);
            System.out.println(q.size());


        } else {
            System.out.println("node full");
        }

    }


}
