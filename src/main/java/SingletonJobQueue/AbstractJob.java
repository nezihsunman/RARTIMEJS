package main.java.SingletonJobQueue;

public class AbstractJob implements Comparable<AbstractJob>{
    private int priority;

    public AbstractJob(int p) {
        this.priority = p;
    }

    public int getPriority() {
        return this.priority;
    }

    @Override
    public int compareTo(AbstractJob j) {
        if (this.getPriority() < j.getPriority()) {
            return 1;
        }

        else if (this.getPriority() > j.getPriority()) {
            return -1;
        }

        return 0;
    }
}
