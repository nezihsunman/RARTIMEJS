package test.java;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Node.Cluster;
import main.java.Node.Node;
import main.java.Node.Observer;
import main.java.Scheduler.NewScheduler;
import main.java.SingletonJobQueue.JobQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;


public class ProducerConsumerTests {
    @Test
    public void test_Should_Initialize_Only_One_Object() throws InterruptedException{
        Cluster c = Cluster.getSingletonInstance();
        Node n = new Node(2);
        c.registerNode(n);
        NewScheduler s = new NewScheduler();
//        n.registerObserver(s);

    }

    @Test
    public void test_Should_Remove_Lowest_Priority() {

    }
}

