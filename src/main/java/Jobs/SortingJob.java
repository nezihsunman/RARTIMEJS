package main.java.Jobs;


import java.util.ArrayList;
import java.util.Random;

public class SortingJob extends AbstractJob {
    //TODO will be replaced with enum
    private boolean status = false;
    private ArrayList<Integer> list;

    // random size array generation in the constructor.
    // could use a different data structure for benefitting from the
    //abstract factory more.
    public SortingJob(int size) {
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
}
