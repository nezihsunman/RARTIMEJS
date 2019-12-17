package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.RandomSortingJob;
import main.java.Jobs.SortingJob;

import java.util.ArrayList;

public class SortingJobFactory implements JobFactory {

    @Override
    public AbstractJob getJob(ArrayList<Integer> list) {
        if (list == null) {
            return new RandomSortingJob();
        } else {
            return new SortingJob(list);
        }
    }

}
