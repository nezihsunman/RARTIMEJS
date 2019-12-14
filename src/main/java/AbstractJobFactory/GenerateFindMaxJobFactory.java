package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.FindMaxJob;

import java.util.ArrayList;

public class GenerateFindMaxJobFactory implements SimpleJobFactory {

    @Override
    public AbstractJob getJob(ArrayList<Integer> list) {
        return new FindMaxJob(list);
    }

    @Override
    public AbstractJob getJob() {
        return null;
    }
}