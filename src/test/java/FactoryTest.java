package test.java;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;

//import main.java.AbstractJobFactory.SortingJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactoryTest {
    private ExecutorService executorService;
    private final AbstractJobFactory abstractJobFactory = new FindMaxJobFactory();

    @Before
    public void start() {
        executorService = Executors.newSingleThreadExecutor();
    }
    @Before
    public void stop() {
        executorService.shutdown();
    }
    @Test
    public void testGivenFooWhenIncrementGetOne() throws Exception {
        AbstractJob job = abstractJobFactory.getJob();

    }

    @Test
    public void test_Should_Create_Array_Of_Integers() {
        JobQueue q = JobQueue.getSingletonInstance();
        AbstractJobFactory jf_max = new FindMaxJobFactory();
        for (int i = 0; i < 5; i ++) {
            jf_max.getJob();
        }

        Assert.assertEquals(JobQueue.getSingletonInstance().size(), 5);
    }


}
