package test.java;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcurrentTestRunner.class)
public class ThreadTest extends Thread {
    private final AbstractJobFactory abstractJobFactory = new FindMaxJobFactory();
    AbstractJob job = abstractJobFactory.getJob();


    @Test
    public void addOne() {

    }

    @After
    public void testCount() {
    }
}