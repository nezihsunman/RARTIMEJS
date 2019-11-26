package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import java.util.List;

public class Node implements Observer{
    private int core;
    private int ram;

    // not sure if they need to be public
    public List<Observer> nodes;
    private JobQueue jobQueue = JobQueue.getInstance();

    public Node(int core, int ram) {
        this.core = core;
        this.ram = ram;

    }

    public void pushToQueue(AbstractJob job) {
        jobQueue.add(job);
    }

    public Object popFromQueue() {
        return jobQueue.remove();
    }

    //TODO will use strategy pattern.
    public void solveProblem(){
        AbstractJob job = (AbstractJob) popFromQueue();
        //job will be solved with strategy pattern
        // update method will be called at the end of strategy pattern
        //to move to the next job
        update(job);
    }

    @Override
    public void update(AbstractJob job) {
//        job.setStatus("Completed");

    }
}
