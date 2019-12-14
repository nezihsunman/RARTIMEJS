package main.java.Jobs;

import main.java.executeStrategy.NoFindMax;
import main.java.executeStrategy.QuickSort;

import java.util.ArrayList;
import java.util.Random;

public class SortingJob extends AbstractJob implements Runnable {
    //TODO will be replaced with enum
    private boolean status = false;
    private ArrayList<Integer> list;

    public SortingJob() {
        findMaxExecudeStrategyInterfaceBehaviour=new NoFindMax();
        list = new ArrayList<Integer>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1000));
        }
        sortExecudeStrategyInterfaceBehaviour=new QuickSort();
    }

    @Override
    public boolean getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int getSize() {
        return this.list.size();
    }
}
