package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJobs;
import main.java.Jobs.FindMaxJobs;
import main.java.SingletonJobQueue.AbstractJob;

public class FindMaxJobFactory implements AbstractJobFactory {
    @Override
    public AbstractJobs getJob(int core, int ram, int jobtime) {
        return new FindMaxJobs(core, ram, jobtime);
    }

    public void createRandomFindMaxJob() {

    }


}
