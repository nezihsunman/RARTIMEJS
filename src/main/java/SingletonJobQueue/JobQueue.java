package main.java.SingletonJobQueue;

import java.util.PriorityQueue;
import main.java.Jobs.AbstractJob;
import main.java.Node.Observer_o;

public class JobQueue<J> extends PriorityQueue<J> implements Observer_o {

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

    @Override
    public void update(AbstractJob job) {

    }
}

