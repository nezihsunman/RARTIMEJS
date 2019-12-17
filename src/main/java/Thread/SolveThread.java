package main.java.Thread;

import main.java.Node.Node;

public class SolveThread extends Thread {
    private Node node;

    public SolveThread(Node node) {
        this.node = node;
    }

    @Override
    public void run() {
        try {
            node.solveProcess();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
