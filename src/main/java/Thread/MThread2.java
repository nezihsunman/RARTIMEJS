package main.java.Thread;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

public class MThread2 implements Runnable {
    JobQueue<AbstractJob> jobs;
    Thread t;

   public MThread2(String thread, JobQueue<AbstractJob> jobQueue) {
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
