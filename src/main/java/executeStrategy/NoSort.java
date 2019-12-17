package main.java.executeStrategy;

import java.util.ArrayList;

public class NoSort implements SortExecudeStrategyInterface{
    @Override
    public synchronized ArrayList<Integer> executeSort(ArrayList<Integer> list) {
        //NO Action
        return null;
    }
}
