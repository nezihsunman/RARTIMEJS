package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.Scheduler.NewScheduler;
import main.java.Scheduler.Scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Node implements Observable, Runnable {
    int core;
    private String status;
    public ArrayList<AbstractJob> jobList = new ArrayList<AbstractJob>();
    private final Set<Observer> mObservers = Collections.newSetFromMap(
            new ConcurrentHashMap<Observer, Boolean>(0));

    public Node(int core, Observer scheduler) throws InterruptedException {
        this.core = core;
        this.status = "Available";
        Thread solveThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solveProblem();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        solveThread.start();
        System.out.println("Thread Solve problem is created");
        Observer observer1= scheduler;
        registerObserver(observer1);
        notifyObservers();
    }

    public Node(int core) {
        this.core = core;
    }

    //Therad 3
    public synchronized void solveProblem() throws InterruptedException {
        while (true) {
//
            while (jobList.size() == 0) {
                System.out.println("job list is empty");
                wait(1000);
                notifyObservers();
            }

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
//        notifyObservers();
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
