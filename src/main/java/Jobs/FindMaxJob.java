package main.java.Jobs;

import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;
import java.util.Random;

public class FindMaxJob extends AbstractJob implements Runnable {
    //TODO will be replaced with enum
    private boolean putstatus = true;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    JobQueue q = JobQueue.getSingletonInstance();

    @Override
    public void run() {

    }

    public FindMaxJob() {
        Random random = new Random();
        int randomSize = random.nextInt(10);
        for (int i = 0; i < randomSize ; i++) {
            list.add(random.nextInt(1000));
        }
        q.add(this);

    }
//    // random size array generation in the constructor.
//    private void FindMaxJob2(int size) {
//        this.list = new ArrayList<Integer>(size);
//        Random random = new Random();
//        for (int i = 0; i < size; i++) {
//            this.list.add(random.nextInt(1000));
//        }
//
//    }

//    public synchronized void createRandomJob() throws InterruptedException {
//        while (this.putstatus == false) {
//            wait();
//        }
//        this.putstatus = false;
//        Random random = new Random();
//        int tempSize = random.nextInt(10);
//        FindMaxJob2(tempSize);
//
//
//        //Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
//    }

    @Override
    public synchronized FindMaxJob getJob() throws InterruptedException {
//        this.createRandomJob();
        AbstractJob J = new FindMaxJob();
        while (putstatus == true) {
            wait();//By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
        }
        this.putstatus = true;
        System.out.println("put message");
//        q.add(J);
        notify();
        return this;
    }

    @Override
    public boolean getStatus() {
        return this.putstatus;
    }


    @Override
    public void setStatus(boolean status) {
        this.putstatus = status;
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public String toString() {
        return "Type: FindMaxJob, Size: " + getSize() + ", Status: " + getStatus();
    }
}
