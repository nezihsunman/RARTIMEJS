package main.java.Jobs;

import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class FindMaxJob extends AbstractJob implements Runnable {
    //TODO will be replaced with enum
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private boolean status = false;
    String uniqueID = UUID.randomUUID().toString();

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

    public String getUniqueID() {
        return this.uniqueID;
    }

    @Override
    public String toString() {
        return String.format("ID" + getUniqueID() + ", Size: " + getSize() + ", Status: " + getStatus());
    }
}
