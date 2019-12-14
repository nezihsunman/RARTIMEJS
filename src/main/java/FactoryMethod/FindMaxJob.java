package main.java.FactoryMethod;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class FindMaxJob extends AbstractJob {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private boolean status = false;
    String uniqueID = UUID.randomUUID().toString();

    public FindMaxJob() {
        Random random = new Random();
        int randomSize = random.nextInt(10);
        for (int i = 0; i < randomSize; i++) {
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
        return list.size();
    }
}
