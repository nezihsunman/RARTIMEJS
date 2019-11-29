package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Node implements Observable, Runnable {
    int core;
    private String status;
    private ArrayList<AbstractJob> jobList;
    private final Set<Observer> mObservers = Collections.newSetFromMap(
            new ConcurrentHashMap<Observer, Boolean>(0));

    public Node(int core)
    {
        this.core = core;
        this.status = "Available";
        this.jobList = jobList;
    }

    public synchronized void solveProblem() throws InterruptedException {
        while (this.getNodeStatus() == "Busy") {
            System.out.println("Still Busy");
            wait();

        }
        this.setNodeStatus("Available");
        System.out.println("Strategy goes here");
//      get job from joblist
//        AbstractJob J = jobList.remove(0);
//        Strategy(J)
        notifyObservers();

    }

    public String getNodeStatus() {
        return status;
    }

    public void addJob(AbstractJob J) {
        jobList.add(J);
    }

    void removeJob(AbstractJob J) {
        jobList.remove(J);
    }

    public void setNodeStatus(String s) {
        this.status = s;
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
    public void notifyObservers() {
        for (Observer observer : mObservers) { // this is safe due to thread-safe Set
            observer.onObservableChanged(this);
        }
    }

    @Override
    public void run() {

    }
}
