package test.java;

import static org.junit.Assert.assertEquals;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;

@RunWith(ConcurrentTestRunner.class)
public class ThreadTest extends Thread {
    private final AbstractJobFactory abstractJobFactory = new FindMaxJobFactory();
    AbstractJob job = abstractJobFactory.getJob();

    @Before
    public void initialCount() {
        try {
            job.getJob();
//            job.createRandomJob();
//            job.createRandomJob();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addOne() {

    }

    @After
    public void testCount() {
    }
}