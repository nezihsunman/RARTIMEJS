package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJobs;
import main.java.Jobs.SortingJobs;
import main.java.SingletonJobQueue.AbstractJob;

public class SortingJobFactory implements AbstractJobFactory {

    @Override
    public AbstractJobs getJob(int cpu, int ram, int jobtime) {
        return new SortingJobs(cpu, ram, jobtime);
    }

    public void createRandomSortingJob() {

    }
}
