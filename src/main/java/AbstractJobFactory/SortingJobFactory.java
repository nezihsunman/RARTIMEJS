package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.SortingJob;

public class SortingJobFactory implements AbstractJobFactory {

    @Override
    public AbstractJob getJob(int size) {
        return new SortingJob(size);
    }
}
//public class SortingJobFactory implements AbstractJobFactory {

//    @Override
//    public AbstractJob getJob(int cpu, int ram, int jobtime) {
//        return new SortingJob(cpu, ram, jobtime);
//    }
//
//    public void createRandomSortingJob() {
//
//    }
//}
