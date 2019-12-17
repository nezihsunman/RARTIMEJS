package main.java.command;

import main.java.Scheduler.NewScheduler;
import main.java.Thread.ConsumeThread;
import main.java.Thread.ProduceThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ProducerCommand implements Command {
    NewScheduler scheduler;

    public ProducerCommand(NewScheduler scheduler) {
        this.scheduler=scheduler;
    }

    @Override
    public void takeCommand() {
        ProduceThread produceThread= new ProduceThread(this.scheduler);

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

        exec.scheduleAtFixedRate(produceThread, 1, 10, TimeUnit.SECONDS);

    }
}
