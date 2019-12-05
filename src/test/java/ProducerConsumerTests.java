package test.java;

import main.java.Node.Cluster;
import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;
import org.junit.Test;



public class ProducerConsumerTests {
    @Test
    public void test_Should_Never_End() throws InterruptedException{
        Cluster c = Cluster.getSingletonInstance();
        Node n = new Node(2);
        c.registerNode(n);
        NewScheduler s = new NewScheduler();

    }

    @Test
    public void test_Should_Remove_Lowest_Priority() {

    }
}

