package main.java.Jobs;

import main.java.executeStrategy.FindMaxExecudeStrategyInterface;
import main.java.executeStrategy.SortExecudeStrategyInterface;

import java.util.ArrayList;

//public abstract class AbstractJob implements Comparable<AbstractJob>{
public abstract class AbstractJob extends Thread implements Comparable<AbstractJob> {
    FindMaxExecudeStrategyInterface findMaxExecudeStrategyInterfaceBehaviour;
    SortExecudeStrategyInterface sortExecudeStrategyInterfaceBehaviour;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public abstract boolean getStatus();

    public abstract void setStatus(boolean status);

    public abstract int getSize();

    @Override
    //pop lowest priority first
    public int compareTo(AbstractJob j) {
        if (this.getSize() > j.getSize()) {
            return 1;
        } else if (this.getSize() < j.getSize()) {
            return -1;
        }

        return 0;
    }
    public ArrayList<Integer> getList() {
        return list;
    }

    public FindMaxExecudeStrategyInterface getFindMaxExecudeStrategyInterfaceBehaviour() {
        return findMaxExecudeStrategyInterfaceBehaviour;
    }

    public void setFindMaxExecudeStrategyInterfaceBehaviour(FindMaxExecudeStrategyInterface findMaxExecudeStrategyInterfaceBehaviour) {
        this.findMaxExecudeStrategyInterfaceBehaviour = findMaxExecudeStrategyInterfaceBehaviour;
    }

    public SortExecudeStrategyInterface getSortExecudeStrategyInterfaceBehaviour() {
        return sortExecudeStrategyInterfaceBehaviour;
    }

    public void setSortExecudeStrategyInterfaceBehaviour(SortExecudeStrategyInterface sortExecudeStrategyInterfaceBehaviour) {
        this.sortExecudeStrategyInterfaceBehaviour = sortExecudeStrategyInterfaceBehaviour;
    }
}
