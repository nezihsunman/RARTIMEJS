package main.java.SingletonJobQueue;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;

import java.util.PriorityQueue;

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

    synchronized public void addQue() throws InterruptedException {
//        getSingletonInstance();
        AbstractJobFactory jobFactory = new FindMaxJobFactory();
        instance.add(jobFactory.getJob());
        System.out.println("Added a Job to Singleton Priority Queue");
    }

    synchronized public AbstractJob popFromQue() throws InterruptedException {
//        getSingletonInstance();
        while (instance.isEmpty()) {
            Thread.sleep(1000);
            System.out.println("Waiting in popFromQue");
        }
        System.out.println("Removedddddd");
        return instance.remove();
    }
}

