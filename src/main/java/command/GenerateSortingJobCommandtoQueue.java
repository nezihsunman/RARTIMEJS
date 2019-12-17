package main.java.command;

import main.java.JobFactory.JobFactory;
import main.java.JobFactory.SortingJobFactory;
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
