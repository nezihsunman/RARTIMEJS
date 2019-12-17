package main.java.Thread;

import main.java.Scheduler.NewScheduler;

public class ConsumeThread extends Thread {
    private NewScheduler s;

    public ConsumeThread(NewScheduler scheduler) {
        this.s = scheduler;
    }

    @Override
    public void run() {
        try {
            s.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
