package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJobs;

public interface AbstractJobFactory {
    AbstractJobs getJob(int cpu, int ram, int jobtime);
}
