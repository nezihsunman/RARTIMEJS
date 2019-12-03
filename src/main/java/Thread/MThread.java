package main.java.Thread;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

//Therad
public class MThread extends Thread {
    JobQueue<AbstractJob> jobs;
    Thread t;

    public MThread(String thread) {
        String name = thread;
        t = new Thread(this, name);
//        System.out.println("New thread: " + t);

        t.start();
    }

    @Override
    public void run() {
        try {
            jobs = JobQueue.getSingletonInstance();
            jobs.addQue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
