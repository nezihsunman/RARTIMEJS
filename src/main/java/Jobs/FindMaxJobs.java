package main.java.Jobs;

public class FindMaxJobs extends AbstractJobs {
    private int core;
    private int ram;
    private int jobTime;

    public FindMaxJobs(int core, int ram, int jobTime) {
        this.core = core;
        this.ram = ram;
        this.jobTime = jobTime;
    }

    @Override
    public void notifyNodes() {
        //todo: this will be removed after implement observer
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

    public int getJobTime() {
        return jobTime;
    }

    public void setJobTime(int jobTime) {
        this.jobTime = jobTime;
    }
}
