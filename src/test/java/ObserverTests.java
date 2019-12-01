package test.java;

//import main.java.SingletonJobQueue.JobQueue;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Node.Node;
import main.java.Scheduler.Scheduler;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(ConcurrentTestRunner.class)
public class ObserverTests {

    private final AbstractJobFactory abstractJobFactory = new FindMaxJobFactory();

    @Test
    public void test_Should_Call_The_Update_Method_When_Problem_Is_Solved() throws InterruptedException {
        AbstractJobFactory jf_max = new FindMaxJobFactory();
        for (int i = 0; i <1500; i++) {
            jf_max.getJob();
        }


        Scheduler s = new Scheduler();
        Node n = new Node(4);
        s.onObservableChanged(n);
        n.registerObserver(s);
        n.solveProblem();

    }

}
