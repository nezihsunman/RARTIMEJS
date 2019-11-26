package test.java;
import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;

//import main.java.AbstractJobFactory.SortingJobFactory;
import main.java.Jobs.AbstractJob;
import org.junit.Test;
import org.junit.Assert;

public class FactoryTest {
    @Test
    public void test_Should_Create_Array_Of_Integers() {
        AbstractJobFactory jf_max = new FindMaxJobFactory();
        AbstractJob j_max = jf_max.getJob(15);

        Assert.assertEquals(j_max.getSize(), 15);
    }

}
