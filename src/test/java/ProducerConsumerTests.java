package test.java;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;
import main.java.Scheduler.Scheduler;
import main.java.SingletonJobQueue.JobQueue;
import org.junit.Assert;
import org.junit.Test;


public class ProducerConsumerTests {
    @Test
    public void test_Should_Initialize_Only_One_Object() throws InterruptedException{

        NewScheduler s = new NewScheduler();
        System.out.println("-----------------------------------------------------------------------------");
        Node n= new Node(4,s);


    }

    @Test
    public void test_Should_Remove_Lowest_Priority() {

    }
}

