package main.java.SingletonJobQueue;

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
}

