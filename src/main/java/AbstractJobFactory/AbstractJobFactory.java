package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;

public interface AbstractJobFactory {
    AbstractJob getJob(int size);
}
