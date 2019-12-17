package main.java.command;

import main.java.Scheduler.NewScheduler;
import main.java.Thread.ConsumeThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsumerCommand implements Command {
    NewScheduler scheduler;

    public ConsumerCommand(NewScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void takeCommand() {
        ConsumeThread consumeThread = new ConsumeThread(this.scheduler);

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

        exec.scheduleAtFixedRate(consumeThread, 1, 10, TimeUnit.SECONDS);

    }
}
