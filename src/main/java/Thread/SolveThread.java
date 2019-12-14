package main.java.Thread;

import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;

public class SolveThread extends Thread {
    private Node s;

    public SolveThread(Node scheduler) {
        this.s = scheduler;
    }

    @Override
    public void run() {
        try {
            s.solveProblem();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
