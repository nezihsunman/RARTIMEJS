package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.FindMaxJob;

public class FindMaxJobFactory implements AbstractJobFactory {
    @Override
    public AbstractJob getJob(int size) {
        return new FindMaxJob(size);
    }
}
