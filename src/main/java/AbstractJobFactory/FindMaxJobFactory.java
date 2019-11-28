package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.FindMaxJob;

public class FindMaxJobFactory extends Thread implements AbstractJobFactory {
    @Override
    public AbstractJob getJob() {
        return new FindMaxJob();
    }
}
