package main.java.Threads;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;


//public class ProducerConsumer {
//    JobQueue queue = JobQueue.getSingletonInstance();
//    AbstractJobFactory jf_max = new FindMaxJobFactory();
//    //capacity is 2 for easier demonstration.
//    int capacity = 2;
//
//    public void consume() throws InterruptedException {
//        while(true) {
//            synchronized (this) {
//                while (queue.size() == 0) {
//                    wait();
//                }
//
//                AbstractJob J = (AbstractJob) queue.remove();
//                J.setStatus(true);
//                System.out.println("Consumer consumed-" + J);
//                //Wake Up Producer Thread
//                notify();
//                //Sleep
//                Thread.sleep(1000);
//
//            }
//        }
//
//    }
//
//    public void produce() throws InterruptedException {
//        int value = 0;
//        while (true) {
//            synchronized (this) {
//                //producer waits while list is full
//                while (queue.size() == capacity) {
//                    System.out.println("Queue size is: " + queue.size());
//                    System.out.println("Waiting...");
//                    wait();
//                    System.out.println("Got notified");
//                    System.out.println("List size is not equal to capacity anymore: " + queue.size());
//
//                }
//
//                AbstractJob J = jf_max.getJob();
//                System.out.println("Producer produced job: " + J.toString());
//                queue.add(J);
//                value++;
//                notify();
//                //and sleep
//                Thread.sleep(1000);
//
//            }
//        }
//
//    }
//}

