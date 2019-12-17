package main.java.SingletonJobQueue;

import main.java.Jobs.AbstractJob;

import java.util.PriorityQueue;

import static main.java.Gui.ANSI_BLACK;

public class JobQueue<J> extends PriorityQueue<J> {

    private static JobQueue<AbstractJob> instance = new JobQueue<AbstractJob>();

    private JobQueue() {

    }

    public static JobQueue getSingletonInstance() {
        if (null == instance) {
            synchronized (JobQueue.class) {
                if (null == instance) {
                    instance = new JobQueue();
                }
            }
        }
        return instance;
    }

    synchronized public void addQue(AbstractJob job) {
        getSingletonInstance().add(job);
        System.out.println(ANSI_BLACK + "Added a Job to Singleton Priority Queue");
    }

}

