package main.java.Threads;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;


public class ProducerConsumer {
    JobQueue queue = JobQueue.getSingletonInstance();
    AbstractJobFactory jf_max = new FindMaxJobFactory();
    //capacity is 6 for easier demonstration.
    int capacity = 6;

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while (queue.size() == 0) {
                    try {
                        System.out.println("Nothing is in the Priority Queue. Consumer is waiting.");
                        wait();
                        System.out.println("Producer added something to the PriorityQueue and notified the consumer.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                AbstractJob J = (AbstractJob) queue.remove();
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
                while (queue.size() == capacity)
                    wait();
                AbstractJob J = jf_max.getJob();
                System.out.println("Produced a new job");
                queue.add(J);
                System.out.println("Queue Size is: " + queue.size());
                //notifies the producer thread
                //so it can start consuming
                notify();
                //and sleep
                Thread.sleep(2000);

            }
        }

    }
}

