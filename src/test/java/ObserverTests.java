package test.java;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
//import main.java.AbstractJobFactory.SortingJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.Node.Node;
//import main.java.AbstractJobFactory.AbstractJobFactory;
//import main.java.AbstractJobFactory.FindMaxJobFactory;
//import main.java.AbstractJobFactory.SortingJobFactory;
//import main.java.Jobs.AbstractJob;
//import main.java.SingletonJobQueue.JobQueue;

import org.junit.Assert;
import org.junit.Test;

public class ObserverTests {
    @Test
    public void test_Should_Call_The_Update_Method_When_Problem_Is_Solved() {
        Node node = new Node(4, 16);

        AbstractJobFactory jf_max = new FindMaxJobFactory();
//        AbstractJobFactory jf_sort = new SortingJobFactory();

        AbstractJob maxJob = jf_max.getJob(50);
//        AbstractJob sortJob = jf_sort.getJob(30);

        node.pushToQueue(maxJob);
//        node.pushToQueue(sortJob);

        node.solveProblem();
        Assert.assertEquals("Completed", maxJob.getStatus());
    }

    @Test
    public void test_Should_Remove_Lowest_Priority() {
    }
}
