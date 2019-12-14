package main.java.Thread;


import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;

public class NodeThread extends Thread {
    private Node node;

    public NodeThread(Node node) {
        this.node = node;
    }

    @Override
    public void run() {
        try {
            node.notifyObservers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

