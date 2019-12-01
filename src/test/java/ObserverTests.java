package test.java;

//import main.java.SingletonJobQueue.JobQueue;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import main.java.Thread.MThread;
import main.java.Node.Node;
import main.java.Scheduler.Scheduler;
import main.java.SingletonJobQueue.JobQueue;
import main.java.Thread.MThread2;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@RunWith(ConcurrentTestRunner.class)
public class ObserverTests extends Thread{
    @Test
    public void test_Should_Call_The_Update_Method_When_Problem_Is_Solved() throws InterruptedException {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService exec2 = Executors.newSingleThreadScheduledExecutor();

        Scheduler s = new Scheduler();

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                MThread t1 = new MThread("One");
            }
        }, 0, 1, TimeUnit.SECONDS);
        /*exec2.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                MThread2 t2 = new MThread2("Two", JobQueue.getSingletonInstance());
            }
        }, 0, 1, TimeUnit.SECONDS);
*/
        Node n = new Node(4);
        s.onObservableChanged(n);
        n.registerObserver(s);
        n.solveProblem();


    }

}
