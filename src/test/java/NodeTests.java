package test.java;
import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;

//import main.java.AbstractJobFactory.SortingJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.Node.Q;
import main.java.Node.Server;
import main.java.Node.Node;
import main.java.SingletonJobQueue.JobQueue;
import org.junit.Test;
import org.junit.Assert;

public class NodeTests {
    @Test
    public void test_Should_Create_Array_Of_Integers() {
        // creating buffer queue
        Q q = new Q();

        JobQueue serverQueue = JobQueue.getInstance();

        AbstractJobFactory jf_max = new FindMaxJobFactory();
        AbstractJob j1 = jf_max.getJob(5);
        AbstractJob j2 = jf_max.getJob(5);
        AbstractJob j3 = jf_max.getJob(5);
        AbstractJob j4 = jf_max.getJob(5);
        AbstractJob j5 = jf_max.getJob(5);
        AbstractJob j6 = jf_max.getJob(5);

        serverQueue.add(j1);
        serverQueue.add(j2);
        serverQueue.add(j3);
        serverQueue.add(j4);
        serverQueue.add(j5);
//        serverQueue.add(j6);

        // starting consumer thread
        Server s = new Server(q);
        Node n = new Node(q,2);

        AbstractJob j_max = jf_max.getJob(15);

        Assert.assertEquals(j_max.getSize(), 15);
    }

}
