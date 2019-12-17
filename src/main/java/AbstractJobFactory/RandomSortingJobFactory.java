package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.RandomSortingJob;

import java.util.ArrayList;

public class RandomSortingJobFactory implements SimpleJobFactory {

    @Override
    public AbstractJob getJob(ArrayList<Integer> list) {
        return null;
    }

    @Override
    public AbstractJob getJob() {
        return new RandomSortingJob();
    }
}
