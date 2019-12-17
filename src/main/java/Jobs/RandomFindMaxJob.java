package main.java.Jobs;

import main.java.executeStrategy.NoSort;
import main.java.executeStrategy.NormalFindMax;
import main.java.executeStrategy.RecursiveFindMax;

import java.util.ArrayList;
import java.util.Random;

public class RandomFindMaxJob extends AbstractJob implements Runnable {
    //TODO will be replaced with enum
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private boolean status = false;
    //String uniqueID = UUID.randomUUID().toString();


    @Override
    public void run() {

    }

    public RandomFindMaxJob() {

        Random random = new Random();
        int randomSize = Math.abs(random.nextInt(1000))+1;
        list = new ArrayList<Integer>();
        for (int i = 0; i < randomSize; i++) {
            list.add(random.nextInt(1000));
        }
        sortExecudeStrategyInterfaceBehaviour = new NoSort();

        findMaxExecudeStrategyInterfaceBehaviour = new RecursiveFindMax();
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
        return list.size();
    }

    /* public String getUniqueID() {
          return this.uniqueID;
      }*/
    @Override
    public ArrayList<Integer> getList() {
        return this.list;
    }

    @Override
    public String toString() {
        return String.format("ID" + ", Size: " + getSize() + ", Status: " + getStatus());
    }
}
