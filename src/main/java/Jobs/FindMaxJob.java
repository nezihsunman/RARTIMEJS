package main.java.Jobs;

import main.java.executeStrategy.NoSort;
import main.java.executeStrategy.NormalFindMax;

import java.util.Random;
import java.util.UUID;

public class FindMaxJob extends AbstractJob implements Runnable {
    //TODO will be replaced with enum

    private boolean status = false;
    String uniqueID = UUID.randomUUID().toString();


    @Override
    public void run() {

    }

    public FindMaxJob() {

        Random random = new Random();
        int randomSize = random.nextInt(10);
        for (int i = 0; i < randomSize; i++) {
            super.getList().add(random.nextInt(1000));
        }
        sortExecudeStrategyInterfaceBehaviour = new NoSort();
        findMaxExecudeStrategyInterfaceBehaviour = new NormalFindMax();
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
        return super.getList().size();
    }

    public String getUniqueID() {
          return this.uniqueID;
      }

    @Override
    public String toString() {
        return String.format("ID: " + getUniqueID() + ", Size: " + getSize() + ", Status: " + getStatus());
    }
}
