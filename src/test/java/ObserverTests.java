package test.java;

//import main.java.SingletonJobQueue.JobQueue;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.Node.Node;
import main.java.Node.Scheduler;
import org.junit.Test;

public class ObserverTests {
    @Test
    public void test_Should_Call_The_Update_Method_When_Problem_Is_Solved() {
        Scheduler s = new Scheduler();
        Node n = new Node(4);
        n.registerObserver(s);

    }

    @Test
    public void test_Should_Remove_Lowest_Priority() {
    }
}
