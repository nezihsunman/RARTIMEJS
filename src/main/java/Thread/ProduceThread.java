package main.java.Thread;

import main.java.Scheduler.NewScheduler;

public class ProduceThread extends Thread {
    private NewScheduler s;

    public ProduceThread(NewScheduler scheduler) {
      this.s=scheduler;
    }

    @Override
    public void run() {
        try {
            s.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
