package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.SortingJob;

import java.util.ArrayList;

public class GenerateSortingJobFactory implements JobFactory {

    @Override
    public AbstractJob getJob(ArrayList<Integer> list) {
        return new SortingJob(list);
    }

}
