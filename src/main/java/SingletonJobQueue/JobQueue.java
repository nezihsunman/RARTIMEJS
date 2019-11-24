package SingletonJobQueue;

import java.util.PriorityQueue;

public class JobQueue {
    private static JobQueue instance;
    private JobQueue() {
        PriorityQueue<AbstractJob> pq = new PriorityQueue<AbstractJob>(5, new JobComparator());
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

