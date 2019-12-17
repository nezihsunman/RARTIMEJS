package test.java;

import main.java.JobFactory.JobFactory;
import main.java.JobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static main.java.Gui.ANSI_BLACK;


//import main.java.AbstractJobFactory.SortingJobFactory;

public class FactoryTest {
//    private final AbstractJobFactory abstractJobFactory = new FindMaxJobFactory();

    @Test
    public void test_Should_Create_a_Random_Sized_Job() {
        JobQueue q = JobQueue.getSingletonInstance();
    }

    @Test
    public void test_Factory_Method() {
        JobQueue q = JobQueue.getSingletonInstance();
        JobFactory jf_max = new FindMaxJobFactory();
        AbstractJob job =jf_max.getJob(null);
        q.addQue(job);
        assertEquals(1, q.size());
    }
}
