package test.java;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Scheduler.NewScheduler;
import main.java.Scheduler.Scheduler;
import main.java.SingletonJobQueue.JobQueue;
import main.java.Threads.ProducerConsumer;
import org.junit.Assert;
import org.junit.Test;


public class ProducerConsumerTests {

    @Test
    public void test_Should_Have_Queue_Size_At_Most_6() throws InterruptedException {
        NewScheduler s = new NewScheduler();
    }
}

