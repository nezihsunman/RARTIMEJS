package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;

import java.util.ArrayList;

public interface SimpleJobFactory {
    AbstractJob getJob(); //Rando
    AbstractJob getJob(ArrayList<Integer> list);
}
