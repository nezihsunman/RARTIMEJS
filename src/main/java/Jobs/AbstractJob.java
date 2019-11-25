package main.java.Jobs;

public abstract class AbstractJob {
    private int core;
    private int ram;
    private int jobTime;

    public void addJob() {

    }
    public void removeJob () {

    }
    public void notifyNodes() {

    }
    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
