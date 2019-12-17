package main.java.Jobs;

import main.java.executeStrategy.FindMaxExecudeStrategyInterface;
import main.java.executeStrategy.SortExecudeStrategyInterface;

import java.util.ArrayList;

//public abstract class AbstractJob implements Comparable<AbstractJob>{
public abstract class AbstractJob extends Thread implements Comparable<AbstractJob> {
    FindMaxExecudeStrategyInterface findMaxExecudeStrategyInterfaceBehaviour;
    SortExecudeStrategyInterface sortExecudeStrategyInterfaceBehaviour;


    public abstract boolean getStatus();

    public abstract void setStatus(boolean status);

    public abstract int getSize();

    public abstract ArrayList<Integer> getList();

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
