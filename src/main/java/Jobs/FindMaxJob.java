package main.java.Jobs;

import java.util.ArrayList;
import java.util.Random;

public class FindMaxJob extends AbstractJob {
    //TODO will be replaced with enum
    private boolean status = false;
    private ArrayList<Integer> list;

    // random size array generation in the constructor.
    public FindMaxJob(int size) {
        list = new ArrayList<Integer>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++)
        {
            list.add(random.nextInt(1000));
        }
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
//    private int j;
////    private int ram;
////    private int jobTime;
//
//    public FindMaxJob() {
////        this.core = core;
////        this.ram = ram;
////        this.jobTime = jobTime;
//    }
//
//    @Override
//    public void addJob() {
//
//    }
//
//    @Override
//    public void removeJob() {
//
//    }
//
//    @Override
//    public void notifyNodes() {
//        //todo: this will be removed after implement observer
//    }
//    @Override
//    public int getCore() {
//        return core;
//    }
//
//    public void setCore(int core) {
//        this.core = core;
//    }
//
//    public int getRam() {
//        return ram;
//    }
//
//    public void setRam(int ram) {
//        this.ram = ram;
//    }
//
//    public int getJobTime() {
//        return jobTime;
//    }
//
//    public void setJobTime(int jobTime) {
//        this.jobTime = jobTime;
//    }

}
