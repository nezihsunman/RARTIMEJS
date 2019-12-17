package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.Thread.NodeThread;
import main.java.Thread.SolveThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static main.java.Gui.ANSI_BLACK;
import static main.java.Gui.ANSI_RED;

public class Node implements Observable, Runnable {
    int core;
    private String status;
    public ArrayList<AbstractJob> jobList = new ArrayList<AbstractJob>();
    private final Set<Observer> mObservers = Collections.newSetFromMap(
            new ConcurrentHashMap<Observer, Boolean>(0));

    public Node(int core) {
        this.core = core;
        this.status = "Available";
        System.out.println(ANSI_BLACK + "Node is created");
    }

    public void nodeStartThread() {
        //threadNode();
        for (int i = 0; i < this.core; i++) {
            threadNode();
        }
    }

    public synchronized void threadNode() {
        NodeThread nodeThread = new NodeThread(this);
        nodeThread.start();

    }

    public synchronized void solveProblem() throws InterruptedException {
        solveThread();
    }

    public synchronized void solveProcess() throws InterruptedException {
        if (jobList.size() == 0) {
            System.out.println(ANSI_RED + "job list is empty");
            notifyObservers();

        } else {
            synchronized (this) {
                AbstractJob handedJob = jobList.get(0);
                System.out.println(ANSI_BLACK + "The Strategy Pattern will be here to solve the AbstractJob");
                System.out.println(ANSI_RED + "...Solving...");
                handedJob.getFindMaxExecudeStrategyInterfaceBehaviour().executeFindMax(handedJob.getList());
                handedJob.getSortExecudeStrategyInterfaceBehaviour().executeSort(handedJob.getList());
                System.out.println(ANSI_RED + "...Solved...");
                handedJob.setStatus(true);
                System.out.println(ANSI_BLACK + handedJob.toString());
                removeJob(handedJob);
                setNodeStatus("Avaliable");
            }
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
        System.out.println(ANSI_BLACK + "Node has a new Job in the Joblist");
        jobList.add(J);
        solveThread();

    }

    synchronized void removeJob(AbstractJob J) {
        jobList.remove(J);
    }

    public void setNodeStatus(String s) throws InterruptedException {
        this.status = s;
        threadNode();
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

    private void solveThread() {
        SolveThread solveThread = new SolveThread(this);
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(solveThread, 0, 5, TimeUnit.SECONDS);
    }

    @Override
    public void run() {

    }
}
