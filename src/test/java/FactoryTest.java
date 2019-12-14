package test.java;

//import main.java.AbstractJobFactory.AbstractJobFactory;
//import main.java.AbstractJobFactory.FindMaxJobFactory;
//import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;
import main.java.FactoryMethod.*;
import org.junit.Assert;
import org.junit.Test;


//import main.java.AbstractJobFactory.SortingJobFactory;

public class FactoryTest {
//    private final AbstractJobFactory abstractJobFactory = new FindMaxJobFactory();

    @Test
    public void test_Should_Create_a_Random_Sized_Job() {
        JobQueue q = JobQueue.getSingletonInstance();
//        AbstractJobFactory jf_max = new FindMaxJobFactory();
//        AbstractJob J = jf_max.getJob();

//        Assert.assertTrue(J.getSize() > 0);
    }

    @Test
    public void test_Factory_Method() {
        JobQueue q = JobQueue.getSingletonInstance();
//        AbstractJobFactory jf_max = new FindMaxJobFactory();
//        AbstractJob J = jf_max.getJob();

        FindMaxJobFactory jf_max = new FindMaxJobFactory();
        jf_max.getJob("FindMaxJob");
        System.out.println("asd");
    }


}
