package test.java;

import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;
import main.java.Thread.ConsumeThread;
import main.java.Thread.ProduceThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ProducerConsumerTests {
    public static void main(String args[]) throws InterruptedException {
        NewScheduler s = new NewScheduler();

        ProduceThread produceThread = new ProduceThread(s);
        ConsumeThread consumeThread= new ConsumeThread(s);

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(produceThread, 0, 10, TimeUnit.SECONDS);
        exec.scheduleAtFixedRate(consumeThread, 1, 10, TimeUnit.SECONDS);
        Node n = new Node(4);
        n.registerObserver(s);
        n.nodeStartThread();
        Node n1 = new Node(4);
        n1.registerObserver(s);
        n1.nodeStartThread();

        System.out.println("Test START and Code Block is Finished");

    }

}

