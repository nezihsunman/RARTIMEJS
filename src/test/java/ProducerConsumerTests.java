package test.java;

import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;
import org.junit.Test;


public class ProducerConsumerTests {
    @Test
    public void test_Should_Initialize_Only_One_Object() throws InterruptedException{

        NewScheduler s = new NewScheduler();
        System.out.println("-----------------------------------------------------------------------------");
        Node n= new Node(4,s);


    }

    @Test
    public void test_Should_Remove_Lowest_Priority() {

    }
}

