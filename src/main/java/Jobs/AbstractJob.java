package main.java.Jobs;

public abstract class AbstractJob implements Comparable<AbstractJob>{
    private int priority;
    //TODO: will probably replaced with enum
    private String status;


    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int p) {
        this.priority = p;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    @Override
    //pop lowest priority first
    public int compareTo(AbstractJob j) {
        if (this.getPriority() > j.getPriority()) {
            return 1;
        }

        else if (this.getPriority() < j.getPriority()) {
            return -1;
        }

        return 0;
    }

    public abstract void addJob();
    public abstract void removeJob ();
    public abstract void notifyNodes(); //todo: this will be removed after implement observer
    public abstract int getCore();

}
