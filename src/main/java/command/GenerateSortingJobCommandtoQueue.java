package main.java.command;

import main.java.AbstractJobFactory.JobFactory;
import main.java.AbstractJobFactory.SortingJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;

public class GenerateSortingJobCommandtoQueue implements Command {
    ArrayList<Integer> list;

    public GenerateSortingJobCommandtoQueue(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void takeCommand() {
        JobFactory factory = new SortingJobFactory();
        AbstractJob job = factory.getJob(this.list);
        JobQueue.getSingletonInstance().addQue(job);

    }
}
