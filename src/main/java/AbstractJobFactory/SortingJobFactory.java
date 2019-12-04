package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.SortingJob;

public class SortingJobFactory implements AbstractJobFactory {

    @Override
    public AbstractJob getJob() {
        return new SortingJob();
    }
}
