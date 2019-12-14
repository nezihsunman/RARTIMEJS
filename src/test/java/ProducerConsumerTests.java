package test.java;

import main.java.Node.Cluster;
import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;
import main.java.Thread.ConsumeThread;
import main.java.Thread.ProduceThread;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ProducerConsumerTests {
    public static void main(String args[]) throws InterruptedException {
        Cluster c = Cluster.getSingletonInstance();
        Node n = new Node(4);
        c.registerNode(n);
        NewScheduler s = new NewScheduler();
        ProduceThread produceThread = new ProduceThread(s);
        ConsumeThread consumeThread= new ConsumeThread(s);
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(produceThread, 0, 5, TimeUnit.SECONDS);
        exec.scheduleAtFixedRate(consumeThread, 0, 2, TimeUnit.SECONDS);
        System.out.println("Test Finish");

    }

}

