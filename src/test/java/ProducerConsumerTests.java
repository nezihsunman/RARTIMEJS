package test.java;

import main.java.Node.Cluster;
import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ProducerConsumerTests {
    @Test
    public void test_Should_Initialize_Only_One_Object() throws InterruptedException {
        Cluster c = Cluster.getSingletonInstance();
        Node n = new Node(4);
        c.registerNode(n);
        NewScheduler s = new NewScheduler();
        Runnable y = s;
        new Thread(y).start();
        new Thread(y).start();


        ScheduledExecutorService execService
                = Executors.newScheduledThreadPool(1);
        execService.scheduleAtFixedRate(() -> {
            new Thread(y).start();
        }, 0, 2000, TimeUnit.MILLISECONDS);


        //s.consume();
        //s.produce();

        System.out.println("Test Finish");


    }

    @Test
    public void test_Should_Remove_Lowest_Priority() {

    }
}

