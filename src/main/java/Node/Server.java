package main.java.Node;

import main.java.Jobs.AbstractJob;
import main.java.SingletonJobQueue.JobQueue;

public class Server implements Runnable {
    Q q;
    public Server(Q q){
        this.q = q;
        new Thread(this, "Server").start();
    }

    @Override
    public void run()
    {

    }

}
