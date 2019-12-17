package main.java.command;

import main.java.AbstractJobFactory.GenerateFindMaxJobFactory;
import main.java.AbstractJobFactory.SimpleJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;

public class GenerateFindMaxJobCommand implements Command {
    AbstractJob abstractJob;
    ArrayList<Integer> list;

    public GenerateFindMaxJobCommand(ArrayList<Integer> list) {
        this.list=list;
    }

    @Override
    public void takeCommand() {
        SimpleJobFactory factory=new GenerateFindMaxJobFactory();
        AbstractJob job=factory.getJob(this.list);
        JobQueue.getSingletonInstance().addQue(job);

    }
}
