package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.RandomFindMaxJob;

import java.util.ArrayList;

public class RandomFindMaxJobFactory extends Thread implements SimpleJobFactory {
    @Override
    public AbstractJob getJob(ArrayList<Integer> list) {
        return null;
    }

    @Override
    public AbstractJob getJob() {
        return new RandomFindMaxJob();
    }

}
