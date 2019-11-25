package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.FindMaxJob;

public class FindMaxJobFactory implements AbstractJobFactory {
    @Override
    public AbstractJob getJob(int core, int ram, int jobtime) {
        return new FindMaxJob(core, ram, jobtime);
    }

    public void createRandomFindMaxJob() {

    }


}
