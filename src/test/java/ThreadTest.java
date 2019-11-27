package test.java;

import static org.junit.Assert.assertEquals;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;

@RunWith(ConcurrentTestRunner.class)
public class ThreadTest extends Thread {
    private final AbstractJobFactory abstractJobFactory = new FindMaxJobFactory();
    AbstractJob job = abstractJobFactory.getJob(15);

    @Before
    public void initialCount() {
        try {
            job.putMessage();


            ArrayList<Integer> testList = job.getMessage();
            for (int i = 0; i < testList.size(); i++) {
                System.out.println(testList.get(i));
            }
            job.putMessage();

            ArrayList<Integer> testList2 = job.getMessage();
            for (int i = 0; i < testList2.size(); i++) {
                System.out.println(testList2.get(i));
            }

            job.putMessage();
            ArrayList<Integer> testList3 = job.getMessage();
            for (int i = 0; i < testList3.size(); i++) {
                System.out.println(testList3.get(i));
            }
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