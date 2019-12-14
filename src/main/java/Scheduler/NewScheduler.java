package main.java.Scheduler;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.Node.Cluster;
import main.java.Node.Node;
import main.java.Node.Observer;
import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;
//import main.java.Threads.ProducerConsumer;

public class NewScheduler implements Observer{
    private JobQueue queue = JobQueue.getSingletonInstance();
    private Cluster c = Cluster.getSingletonInstance();
    private AbstractJobFactory jf_max = new FindMaxJobFactory();
    private ArrayList<Node> nodes;
    //capacity is 2 for easier demonstration.
    int capacity = 2;

    public NewScheduler() throws InterruptedException{
//        final ProducerConsumer pc = new ProducerConsumer();

        this.nodes = c.getCluster();
        Thread producerThread  = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                }

                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        consumerThread.start();
        producerThread.start();
        consumerThread.join();
        producerThread.join();

    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while (queue.size() == 0) {
                    wait();
                }

                for (Node node : nodes){
                    AbstractJob J = (AbstractJob) queue.remove();
                    node.registerObserver(this);
                    node.addJob(J);
                    node.solveProblem();
                    System.out.println("Consumer consumed-" + J);
                }

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

                AbstractJob J = jf_max.getJob();
                System.out.println("Producer produced job: " + J.toString());
                queue.add(J);
                value++;
                notify();
                //and sleep
                Thread.sleep(1000);

            }
        }

    }
    @Override
    public void onObservableChanged(Node n) throws InterruptedException {
        if (n.checkAvailable()) {
            System.out.println("lalalala");
            if (!queue.isEmpty()) {

                AbstractJob J = (AbstractJob) queue.remove();
                n.addJob(J);
                n.solveProblem();
            }
        }
        else {
            n.setNodeStatus("Busy");
        }
    }

}

