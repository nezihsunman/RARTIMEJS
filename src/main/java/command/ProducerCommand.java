package main.java.command;

import main.java.Scheduler.NewScheduler;
import main.java.Thread.ProduceThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ProducerCommand implements Command, StopCommand {
    NewScheduler scheduler;
    ProduceThread produceThread;
    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

    public ProducerCommand(NewScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void takeCommand() {
        produceThread = new ProduceThread(this.scheduler);
        exec.scheduleAtFixedRate(produceThread, 1, 2, TimeUnit.SECONDS);

    }

    @Override
    public void stopCommand() {
        exec.shutdown();
    }
}
