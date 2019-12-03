package main.java.Threads;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;


public class ProducerConsumer {
    JobQueue queue = JobQueue.getSingletonInstance();
    AbstractJobFactory jf_max = new FindMaxJobFactory();
    //capacity is 2 for easier demonstration.
    int capacity = 2;

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while (queue.size() == 0) {
                    wait();
                }

                Object val = queue.remove();
                System.out.println("Consumer consumed-" + val);
//                AbstractJob J = (AbstractJob) queue.remove();
                //Wake Up Producer Thread
                notify();
                //Sleep
                Thread.sleep(1000);

            }
        }

    }

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                //producer waits while list is full
                while (queue.size() == capacity) {
                    System.out.println("Queue size is: " + queue.size());
                    System.out.println("Waiting...");
                    wait();
                    System.out.println("Got notified");
                    System.out.println("List size is not equal to capacity anymore: " + queue.size());

                }

                System.out.println("Producer produced job: " + value);
//                AbstractJob J = jf_max.getJob();
//                System.out.println("Produced a new job");
//                queue.add(J);
//                System.out.println("Queue Size is: " + queue.size());
                //notifies the producer thread
                //so it can start consuming
                queue.add(value++);
                notify();
                //and sleep
                Thread.sleep(1000);

            }
        }

    }
}

