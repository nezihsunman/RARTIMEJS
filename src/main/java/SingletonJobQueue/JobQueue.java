package main.java.SingletonJobQueue;

import java.util.PriorityQueue;
import main.java.Jobs.AbstractJob;

public class JobQueue<J> extends PriorityQueue<J> {

    private static JobQueue<AbstractJob> instance;

    private JobQueue() {
        //constructor
    }

    synchronized public static JobQueue getInstance() {
        if (instance == null) {
            instance = new JobQueue();
        }

        return instance;
    }
}

