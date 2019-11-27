package main.java.Jobs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class FindMaxJob extends AbstractJob implements Runnable {
    //TODO will be replaced with enum
    private boolean putstatus = true;
    private ArrayList<Integer> list;

    @Override
    public void run() {

    }

    // random size array generation in the constructor.
    public ArrayList<Integer> FindMaxJob2(int size) {
        list = new ArrayList<Integer>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1000));
        }
        return list;
    }

    public synchronized void putMessage() throws InterruptedException {
        while (this.putstatus == false) {
            wait();
        }
        this.putstatus = false;
        Random random = new Random();
        int tempSize = random.nextInt(10);
        this.list = FindMaxJob2(tempSize);
        System.out.println("put message");
        notify();
        //Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
    }

    @Override
    public synchronized ArrayList<Integer> getMessage() throws InterruptedException {
        notify();
        while (putstatus == true) {
            wait();//By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
        }
        this.putstatus = true;
        ArrayList<Integer> tempList = new ArrayList<Integer>(this.list.size());
        Iterator<Integer> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            tempList.add((Integer) iterator.next());
        }
        for (int i = 0; i <this.list.size() ; i++) {
            System.out.println(this.list.get(i));
        }
        list.clear();
        System.out.println("getMessageed");

        return tempList;
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
