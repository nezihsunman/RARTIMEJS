package test.java;
import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;

import main.java.AbstractJobFactory.SortingJobFactory;
import org.junit.Test;
import org.junit.Assert;

public class FactoryTest {
    @Test
    public void test_Should_Initialize_Only_One_Object() {
        int cpu1=1;
        int cpu2=2;
        int ram1=16;
        int ram2=32;

        int jobtime1=10;
        int jobtime2=20;

        AbstractJobFactory factory1;
        AbstractJobFactory factory2;
        factory1=new FindMaxJobFactory();
        factory2=new SortingJobFactory();


        Assert.assertNotEquals(factory1.getJob(cpu1,ram1,jobtime1).getCore(), factory2.getJob(cpu2,ram2,jobtime2).getCore());
        //Assert.assertEquals(singletonQueue.hashCode(), anotherQueue.hashCode());
    }

}
