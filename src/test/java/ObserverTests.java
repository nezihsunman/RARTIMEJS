package test.java;
import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import main.java.Node.Node;
import main.java.Scheduler.Scheduler;
import main.java.Thread.MThread;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@RunWith(ConcurrentTestRunner.class)
public class ObserverTests {
    @Test
    public void test_Should_Call_The_Update_Method_When_Problem_Is_Solved() throws InterruptedException {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService exec2 = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                MThread t1 = new MThread("One");
            }
        }, 0, 5, TimeUnit.SECONDS);
        final Scheduler scheduler = new Scheduler();

        exec2.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    scheduler.popFromQue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5, TimeUnit.SECONDS);


        Node n = new Node(4);
        scheduler.onObservableChanged(n);
        n.registerObserver(scheduler);
        n.solveProblem();


    }

}
