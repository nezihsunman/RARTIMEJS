package main.java.SingletonJobQueue;

import java.util.PriorityQueue;

public class JobQueue<J> extends PriorityQueue<J> {

    private static JobQueue<AbstractJob> instance;

    private JobQueue() {
        //constructor
    }

    synchronized public static JobQueue getInstance() {
        //TODO: Could be replaced with template behavioral pattern.
        if (instance == null) {
            instance = new JobQueue();
        }

        return instance;
    }
}

