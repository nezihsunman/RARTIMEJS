package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.RandomSortingJob;

import java.util.ArrayList;

public class RandomSortingJobFactory implements JobFactory {

    @Override
    public AbstractJob getJob(ArrayList<Integer> list) {
        if (list ==null) {
            return new RandomSortingJob();
        }
        else return null;
    }

}
