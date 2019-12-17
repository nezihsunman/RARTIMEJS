package main.java.Scheduler;

import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.AbstractJobFactory.JobFactory;
import main.java.Jobs.AbstractJob;
import main.java.Node.Node;
import main.java.Node.Observer;
import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;

import static test.java.CommandClient.ANSI_BLACK;
import static test.java.CommandClient.ANSI_RED;
//import main.java.Threads.ProducerConsumer;

public class NewScheduler extends Thread implements Observer {

    JobFactory jf_max = new FindMaxJobFactory();
    private static ArrayList<AbstractJob> tempJobList = new ArrayList<AbstractJob>();
    private int capacity = 10;

    public NewScheduler() {
        System.out.println(ANSI_BLACK + "NewScheduler is initialised");
    }

    public synchronized void consume() throws InterruptedException {
        JobQueue queue = JobQueue.getSingletonInstance();
        if (!queue.isEmpty()) {
            AbstractJob J = (AbstractJob) queue.remove();
            this.addTempJobList(J);
            System.out.println(ANSI_BLACK + "Took a job from Priority Queue and gave it to Scheduler.");

        } else {
            System.out.println(ANSI_RED + " !!! Queue empty !!!");
        }
    }

    public synchronized void produce() throws InterruptedException {
        JobQueue queue = JobQueue.getSingletonInstance();
        //producer waits while list is full
        if (queue.size() == capacity) {
            System.out.println(ANSI_BLACK + "Queue size is: " + queue.size());
            System.out.println(ANSI_BLACK + "Waiting... in Produce");

        } else {
            AbstractJob J = jf_max.getJob(null);
            System.out.println(ANSI_BLACK + "Producer produced job: " + J.toString());
            queue.add(J);
        }

    }

    @Override
    public synchronized void onObservableChanged(Node n) throws InterruptedException {
        if (n.checkAvailable()) {
            while (this.sizeTempJobList() == 0) {
                System.out.println("Node is Waiting because Scheduler is Empty ");
                wait(10000);

            }
            n.addJob(removeTempJobList());
            System.out.println(ANSI_BLACK + "Temp Scheduler size is: " + this.sizeTempJobList());
            System.out.println(ANSI_BLACK + "Node Job capacity is: " + n.jobList.size());

        }

    }

    private synchronized void addTempJobList(AbstractJob J) {
        this.tempJobList.add(J);
    }

    private synchronized AbstractJob removeTempJobList() {
        return this.tempJobList.remove(0);
    }

    private synchronized int sizeTempJobList() {
        return this.tempJobList.size();
    }


}
