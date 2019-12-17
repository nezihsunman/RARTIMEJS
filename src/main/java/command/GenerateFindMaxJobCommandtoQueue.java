package main.java.command;

import main.java.AbstractJobFactory.JobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;

public class GenerateFindMaxJobCommandtoQueue implements Command {
    ArrayList<Integer> list;

    public GenerateFindMaxJobCommandtoQueue(ArrayList<Integer> list) {
        this.list=list;
    }

    @Override
    public void takeCommand() {
        JobFactory factory=new FindMaxJobFactory();
        AbstractJob job=factory.getJob(this.list);
        JobQueue.getSingletonInstance().addQue(job);

    }
}
