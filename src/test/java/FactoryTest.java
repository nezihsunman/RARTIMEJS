package test.java;

//import main.java.AbstractJobFactory.AbstractJobFactory;
//import main.java.AbstractJobFactory.FindMaxJobFactory;
//import main.java.Jobs.AbstractJob;
import main.java.AbstractJobFactory.GenerateFindMaxJobFactory;
import main.java.AbstractJobFactory.JobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;
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
        JobFactory jf_max = new GenerateFindMaxJobFactory();
        AbstractJob job =jf_max.getJob(null);
        System.out.println("Job Generated");
    }


}
