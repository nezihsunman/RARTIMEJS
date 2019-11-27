package main.java.Jobs;

import java.util.ArrayList;

//public abstract class AbstractJob implements Comparable<AbstractJob>{
public abstract class AbstractJob extends Thread implements Comparable<AbstractJob> {
//    private String status;
//    private int priority;
    //TODO: will probably replaced with enum
    public abstract void putMessage() throws InterruptedException;
    public abstract ArrayList<Integer> getMessage() throws InterruptedException;
    public abstract boolean getStatus();
    public abstract void setStatus(boolean status);
    public abstract int getSize();

//    public String getStatus() {
//        return this.status;
//    }
//
//    // TODO: will be replaced boolean status
//    public void setStatus(String s) {
//        this.status = s;
//    }

//    public int getPriority() {
//        return this.priority;
//    }
//
//    public void setPriority(int p) {
//        this.priority = p;
//    }


    @Override
    //pop lowest priority first
    public int compareTo(AbstractJob j) {
        if (this.getSize() > j.getSize()) {
            return 1;
        }

        else if (this.getSize() < j.getSize()) {
            return -1;
        }

        return 0;
    }

//    public abstract void addJob();
//    public abstract void removeJob ();
//    public abstract void notifyNodes(); //todo: this will be removed after implement observer
//    public abstract int getCore();

}
