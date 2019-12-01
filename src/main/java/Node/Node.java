package main.java.Node;

import main.java.Jobs.AbstractJob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Node implements Observable, Runnable {
    int core;
    private String status;
    private ArrayList<AbstractJob> jobList = new ArrayList<AbstractJob>();
    private final Set<Observer> mObservers = Collections.newSetFromMap(
            new ConcurrentHashMap<Observer, Boolean>(0));

    public Node(int core) throws InterruptedException {
        this.core = core;
        this.status = "Available";
        notifyObservers();
    }

    //Therad 3
    public synchronized void solveProblem() throws InterruptedException {
        while (true) {
//
            if (jobList.size() == 0) {
                break;
            }

            int tempJobSize = jobList.size();
            // todo: This call stragty patern to hande the solition in try catch blog
            AbstractJob handedJob = jobList.remove(0);
            System.out.println("The Strategy Pattern will be here to solve the AbstractJob");
            System.out.println("...Solving...");
            wait(5000);
            notifyObservers();

        }


    }

    public boolean checkAvailable() {
        if (this.jobList.size() < this.core) {
            return true;
        } else {
            return false;
        }
    }

    public String getNodeStatus() {
        return status;
    }

    public void addJob(AbstractJob J) {
        System.out.println("Node has a new Job in the Joblist");
        jobList.add(J);
//        notifyObservers();
    }

    void removeJob(AbstractJob J) {
        jobList.remove(J);
//        notifyObservers();
    }

    public void setNodeStatus(String s) throws InterruptedException {
        this.status = s;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) return;
        mObservers.add(observer); // this is safe due to thread-safe Set
    }

    @Override
    public void unregisterObserver(Observer observer) {
        if (observer != null) {
            mObservers.remove(observer); // this is safe due to thread-safe Set
        }
    }

    @Override
    public void notifyObservers() throws InterruptedException {
        for (Observer observer : mObservers) { // this is safe due to thread-safe Set
            observer.onObservableChanged(this);
        }
    }

    @Override
    public void run() {

    }
}
