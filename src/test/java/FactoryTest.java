package test.java;
import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;

import org.junit.Test;
import org.junit.Assert;

public class FactoryTest {
    @Test
    public void test_Should_Initialize_Only_One_Object() {
        AbstractJobFactory factory1;
        AbstractJobFactory factory2;
        factory1=new FindMaxJobFactory();
        factory2=new FindMaxJobFactory();


        Assert.assertEquals(factory1.getJob(), factory2.getJob());
        //Assert.assertEquals(singletonQueue.hashCode(), anotherQueue.hashCode());
    }

}
