package main.java.AbstractJobFactory;

import main.java.SingletonJobQueue.AbstractJob;

public interface AbstractJobFactory {
    AbstractJob getJob();
}
