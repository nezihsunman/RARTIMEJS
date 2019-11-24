package test.java;

import main.java.SingletonJobQueue.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class PriorityQueueTests {
    @Test
    public void test_Should_Initialize_Only_One_Object() {
        JobQueue singletonQueue = JobQueue.getInstance();
        JobQueue anotherQueue = JobQueue.getInstance();

        Assert.assertEquals(singletonQueue, anotherQueue);
        //Assert.assertEquals(singletonQueue.hashCode(), anotherQueue.hashCode());
    }

    @Test
    public void test_Should_Remove_Highest_Priority() {
        JobQueue singletonQueue = JobQueue.getInstance();
        AbstractJob j1 = new AbstractJob(5);
        AbstractJob j2 = new AbstractJob(8);
        AbstractJob j3 = new AbstractJob(1);

        singletonQueue.add(j1);
        singletonQueue.add(j2);
        singletonQueue.add(j3);

        Assert.assertEquals(singletonQueue.remove(), j2);

    }
}
