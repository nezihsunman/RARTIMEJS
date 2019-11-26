package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

import java.util.PriorityQueue;

// Consumer class
public class Node implements Runnable {
    Q q;
    int core;
    private String status;

    public Node(Q q, int core)
    {
        this.q = q;
        this.core = core;
        new Thread(this, "Node").start();
    }

    public void run()
    {
        for (int i = 0; i < core; i++) {
            System.out.println("get job from q");
            q.get();
        }
            // consumer get items
//            jobQueue.remove();
        //strategy pattern goes here I guess
    }
}
