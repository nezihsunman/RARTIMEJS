package main.java.Scheduler;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.Jobs.AbstractJob;
import main.java.Node.Node;
import main.java.Node.Observer;
import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;
//import main.java.Threads.ProducerConsumer;

public class NewScheduler implements Observer {
    JobQueue queue = JobQueue.getSingletonInstance();
    AbstractJobFactory jf_max = new FindMaxJobFactory();
    private ArrayList<AbstractJob> tempJobList = new ArrayList<AbstractJob>();
    //capacity is 2 for easier demonstration.
    int capacity = 2;

    public NewScheduler() throws InterruptedException {
//        final ProducerConsumer pc = new ProducerConsumer();
        threadInitialise();
        System.out.println("Thread for cunsumer producer is initialised");
    }

    private synchronized void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0 || this.sizeTempJobList() > 8) {
                    wait();
                }

                AbstractJob J = (AbstractJob) queue.remove();
                addTempJoblist(J);
                System.out.println("---------------------"+ sizeTempJobList());
                J.setStatus(true);
                System.out.println("Consumer consumed-" + J);
                //Wake Up Producer Thread
                notify();
                //Sleep
                Thread.sleep(1000);

            }
        }

    }

    private synchronized void produce() throws InterruptedException {

        while (true) {
            synchronized (this) {
                //producer waits while list is full
                while (queue.size() == capacity) {
                    System.out.println("Queue size is: " + queue.size());
                    System.out.println("Waiting... in Produce");
                    wait();
                    System.out.println("Got notified");
                    System.out.println("List size is not equal to capacity anymore: " + queue.size());

                }
                AbstractJob J = jf_max.getJob();
                System.out.println("Producer produced job: " + J.toString());
                queue.add(J);
                notify();
                //and sleep
                Thread.sleep(1000);

            }
        }

    }

    @Override
    public synchronized void onObservableChanged(Node n) throws InterruptedException {
        if (n.checkAvailable()) {
            while (this.sizeTempJobList() == 0) {
                wait(2000);
                System.out.println("There are no Jobs in the Scheduler.");
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
    public void threadInitialise() throws InterruptedException {
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


        producerThread.start();
        consumerThread.start();
        //Join usage give bug for execute other steps
        /*producerThread.join();
        consumerThread.join();*/

    }
}
