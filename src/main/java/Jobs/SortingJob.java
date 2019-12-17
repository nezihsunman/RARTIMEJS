package main.java.Jobs;

import main.java.executeStrategy.*;

import java.util.ArrayList;

public class SortingJob extends AbstractJob implements Runnable{
    private boolean status = false;
    //String uniqueID = UUID.randomUUID().toString();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public SortingJob(ArrayList<Integer> list) {
        this.list=list;
        super.sortExecudeStrategyInterfaceBehaviour = new BubbleSort();
        super.findMaxExecudeStrategyInterfaceBehaviour = new NoFindMax();
    }

    @Override
    public ArrayList<Integer> getList() {
        return this.list;
    }
    @Override
    public void run() {

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

    /* public String getUniqueID() {
          return this.uniqueID;
      }*/

    @Override
    public String toString() {
        return String.format("ID" + ", Size: " + getSize() + ", Status: " + getStatus());
    }
}
