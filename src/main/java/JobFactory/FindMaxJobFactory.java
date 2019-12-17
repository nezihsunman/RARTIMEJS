package main.java.JobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.FindMaxJob;
import main.java.Jobs.RandomFindMaxJob;

import java.util.ArrayList;

public class FindMaxJobFactory extends Thread implements JobFactory {
    @Override
    public AbstractJob getJob(ArrayList<Integer> list) {
        if (list == null) {
            return new RandomFindMaxJob();
        } else {
            return new FindMaxJob(list);
        }
    }


}
