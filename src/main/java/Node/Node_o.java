package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import java.util.List;

public class Node_o implements Observer_o {
    private int core;
    private int ram;

    // not sure if they need to be public
    public List<Observer_o> nodes;


    public Node_o(int core, int ram) {
        this.core = core;
        this.ram = ram;

    }



    //TODO will use strategy pattern.
    public void solveProblem(){

        //job will be solved with strategy pattern
        // update method will be called at the end of strategy pattern
        //to move to the next job

    }

    @Override
    public void update(AbstractJob job) {
//        job.setStatus("Completed");

    }
}
