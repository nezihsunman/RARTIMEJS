package main.java;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MThread implements Runnable {
    JobQueue<AbstractJob> jobs;
    Thread t;

    MThread(String thread, JobQueue<AbstractJob> jobQueue) {
        String name = thread;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        jobs=jobQueue;
        t.start();
    }

    @Override
    public void run() {
        try {
            jobs.addQue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MThread2 implements Runnable {
    JobQueue<AbstractJob> jobs;
    Thread t;

    MThread2(String thread, JobQueue<AbstractJob> jobQueue) {
        String name = thread;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        jobs=jobQueue;
        t.start();
    }

    @Override
    public void run() {
        try {
            jobs.popFromQue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MultiThread {

    public static void main(String args[])  throws InterruptedException{
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService exec2 = Executors.newSingleThreadScheduledExecutor();

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                MThread t1 = new MThread("One", JobQueue.getSingletonInstance());
            }
        }, 0, 5, TimeUnit.SECONDS);
        exec2.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                MThread2 t2 = new MThread2("Two", JobQueue.getSingletonInstance());
            }
        }, 0, 1, TimeUnit.SECONDS);

        /*t1.jobs.addQue();
        t1.run();
        t1.run();
        t1.run();
        t1.run();

        t1.jobs.addQue();

        t2.jobs.addQue();
        t2.jobs.popFromQue();*/




    }
}

