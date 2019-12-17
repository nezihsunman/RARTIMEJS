package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.RandomFindMaxJob;

import java.util.ArrayList;

public class RandomFindMaxJobFactory extends Thread implements JobFactory {
    @Override
    public AbstractJob getJob(ArrayList<Integer> list) {
        if (list == null) {
            return new RandomFindMaxJob();
        }
        else
            return null;
    }


}
