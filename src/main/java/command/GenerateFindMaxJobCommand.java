package main.java.command;

import main.java.Jobs.AbstractJob;

import java.util.ArrayList;

public class GenerateFindMaxJobCommand implements Command {
    AbstractJob abstractJob;

    public GenerateFindMaxJobCommand(AbstractJob job) {
        this.abstractJob = job;
    }

    @Override
    public void takeCommand() {

    }
}
