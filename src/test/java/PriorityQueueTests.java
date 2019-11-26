package test.java;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
//import main.java.AbstractJobFactory.SortingJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTests {
    @Test
    public void test_Should_Initialize_Only_One_Object() {
        JobQueue singletonQueue = JobQueue.getInstance();
        JobQueue anotherQueue = JobQueue.getInstance();

        Assert.assertEquals(singletonQueue, anotherQueue);
        //Assert.assertEquals(singletonQueue.hashCode(), anotherQueue.hashCode());
    }

    @Test
    public void test_Should_Remove_Lowest_Priority() {
        JobQueue singletonQueue = JobQueue.getInstance();

        AbstractJobFactory jf_max = new FindMaxJobFactory();
//        AbstractJobFactory jf_sort = new SortingJobFactory();

//        AbstractJob maxJob = jf_max.getJob(1 , 16, 10);
//        AbstractJob sortJob = jf_sort.getJob(32,2, 20);
//
//        maxJob.setPriority(jobTime1);
//        sortJob.setPriority(jobTime2);
//
//        singletonQueue.add(maxJob);
//        singletonQueue.add(sortJob);

//        Assert.assertEquals(singletonQueue.remove(), maxJob);

    }
}
