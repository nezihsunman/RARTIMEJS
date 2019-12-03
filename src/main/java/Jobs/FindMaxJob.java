package main.java.Jobs;

import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;
import java.util.Random;

public class FindMaxJob extends AbstractJob implements Runnable {
    //TODO will be replaced with enum
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private boolean status = false;
    JobQueue q = JobQueue.getSingletonInstance();

    @Override
    public void run() {

    }

    public FindMaxJob() {
        Random random = new Random();
        int randomSize = random.nextInt(10);
        for (int i = 0; i < randomSize; i++) {
            list.add(random.nextInt(1000));
        }

    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;

    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public String toString() {
        return String.format("Type: " + getClass() + ", Size: " + getSize() + ", Status: " + getStatus());
    }
}
