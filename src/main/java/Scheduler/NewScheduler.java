package main.java.Scheduler;

import main.java.AbstractJobFactory.SimpleJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.Node.Node;
import main.java.Node.Observer;
import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;
//import main.java.Threads.ProducerConsumer;

public class NewScheduler extends Thread implements Observer {
    JobQueue queue = JobQueue.getSingletonInstance();
    SimpleJobFactory jf_max = new FindMaxJobFactory();
    private static ArrayList<AbstractJob> tempJobList =new ArrayList<AbstractJob>();
    private static ArrayList<Node> NodeList;
    //capacity is 2 for easier demonstration.
    int capacity = 10;

    public NewScheduler() throws InterruptedException {
//        final ProducerConsumer pc = new ProducerConsumer();
        //threadInitialise();
        System.out.println("NewSchuler is initialised");
    }

    public synchronized void consume() throws InterruptedException {
        if (!queue.isEmpty()) {
            AbstractJob J = (AbstractJob) queue.remove();
            //node.registerObserver(this);
            //node.addJob(J);
            //node.solveProblem();
            this.addTempJoblist(J);
            //System.out.println("---------------------" + sizeTempJobList());
            //J.setStatus(true);
            System.out.println("Took a job from Priority Queue and gave it to Scheduler.");

        } else {
            System.out.println("queis empty");
        }
    }

    public synchronized void produce() throws InterruptedException {

        //producer waits while list is full
        if (queue.size() == capacity) {
            System.out.println("Queue size is: " + queue.size());
            System.out.println("Waiting... in Produce");

            System.out.println("Got notified");
            System.out.println("List size is not equal to capacity anymore: " + queue.size());
            System.out.println("Thread intreer");

        } else {
            AbstractJob J = jf_max.getJob();
            System.out.println("Producer produced job: " + J.toString());
            queue.add(J);
            //notify();
            //and sleep
        }

    }

    @Override
    public synchronized void onObservableChanged(Node n) throws InterruptedException {
        if (n.checkAvailable()) {
            while(this.sizeTempJobList() == 0) {
                //System.out.println("There are no Jobs in the Scheduler wait.");
                wait(15000);

            }
                n.addJob(removeTempJobList());
                System.out.println("Temp Scheculer size is: " + this.sizeTempJobList());
                System.out.println("Node Job capacity is: " + n.jobList.size());

        }


    }

    private synchronized void addTempJoblist(AbstractJob J) {
        this.tempJobList.add(J);
    }

    private synchronized AbstractJob removeTempJobList() {
        return this.tempJobList.remove(0);
    }

    private synchronized int sizeTempJobList() {
        return this.tempJobList.size();
    }

    public void producerThread() {
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();

    }

    public void consumerThread() {
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        consumerThread.start();
    }

    public void threadInitialise() throws InterruptedException {
        producerThread();
        consumerThread();

    }

    @Override
    public synchronized void run() {
        try {
            while (true)
                this.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void internalAction() {

    }

}
