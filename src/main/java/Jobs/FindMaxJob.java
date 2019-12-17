package main.java.Jobs;

import main.java.executeStrategy.NoSort;
import main.java.executeStrategy.NormalFindMax;

import java.util.ArrayList;
import java.util.UUID;

public class FindMaxJob extends AbstractJob implements Runnable {
    //TODO will be replaced with enum
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private boolean status = false;
    String uniqueID = UUID.randomUUID().toString();


    @Override
    public ArrayList<Integer> getList() {
        return this.list;
    }

    @Override
    public void run() {

    }

    public FindMaxJob(ArrayList<Integer> list) {
        this.list = list;
        super.sortExecudeStrategyInterfaceBehaviour = new NoSort();
        super.findMaxExecudeStrategyInterfaceBehaviour = new NormalFindMax();
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;

    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    public String getUniqueID() {
        return this.uniqueID;
    }

    @Override
    public String toString() {
        return String.format("ID: " + getUniqueID() + ", Size: " + getSize() + ", Status: " + getStatus());
    }
}

