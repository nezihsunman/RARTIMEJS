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
        exec.scheduleAtFixedRate(produceThread, 0, 1, TimeUnit.SECONDS);
        exec.scheduleAtFixedRate(consumeThread, 0, 1, TimeUnit.SECONDS);
        Node n = new Node(4);
        n.registerObserver(s);
        n.nodeStartThread();
       // n.solveProblem();
        System.out.println("Test Finish");

    }

}

