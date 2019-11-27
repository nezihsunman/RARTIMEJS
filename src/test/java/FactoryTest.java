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
        AbstractJob job = abstractJobFactory.getJob(15);
        try {
            job.putMessage();


            ArrayList<Integer> testList = job.getMessage();
            for (int i = 0; i < testList.size(); i++) {
                System.out.println(testList.get(i));
            }
            job.putMessage();

            ArrayList<Integer> testList2 = job.getMessage();
            for (int i = 0; i < testList2.size(); i++) {
                System.out.println(testList2.get(i));
            }

            job.putMessage();
            ArrayList<Integer> testList3 = job.getMessage();
            for (int i = 0; i < testList3.size(); i++) {
                System.out.println(testList3.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
