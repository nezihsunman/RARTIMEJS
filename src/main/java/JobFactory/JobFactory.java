package main.java.JobFactory;

import main.java.Jobs.AbstractJob;

import java.util.ArrayList;

public interface JobFactory {
    AbstractJob getJob(ArrayList<Integer> list);
}
