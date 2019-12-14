package main.java.Node;

import main.java.Jobs.AbstractJob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Node implements Observable, Runnable {
    int core;
    private Cluster c;
    private String status;
    private ArrayList<AbstractJob> jobList = new ArrayList<AbstractJob>();
    private final Set<Observer> mObservers = Collections.newSetFromMap(
            new ConcurrentHashMap<Observer, Boolean>(0));

    public boolean nodeAvailable() {
        if(0<jobList.size()&& jobList.size()<core)
            return true;
        else if (jobList.size()==core)
            return false;
        else{
            return false;
        }
    }
    public Node(int core) throws InterruptedException {
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

    }

    //Therad 3
    public synchronized void solveProblem() throws InterruptedException {
        while (true) {
            if (!this.nodeAvailable()) {
                System.out.println("job list is empty");
                wait(1000);
                notifyObservers();
                break;
            }
            // todo: This call stragty patern to hande the solition in try catch blog
            AbstractJob J = jobList.get(0);
            System.out.println("The Strategy Pattern will be here to solve the AbstractJob");
            System.out.println("...Solving...");
            wait(5000);
            J.setStatus(true);
            removeJob(J);
            setNodeStatus("Available");

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
//        c.registerNode((Node) observer);
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

    public ArrayList<AbstractJob> getJobList() {
        return jobList;
    }

    public void setJobList(ArrayList<AbstractJob> jobList) {
        this.jobList = jobList;
    }
}
