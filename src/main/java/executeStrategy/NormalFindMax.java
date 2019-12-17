package main.java.executeStrategy;

import java.util.ArrayList;
import java.util.Collections;

public class NormalFindMax implements FindMaxExecudeStrategyInterface {

    @Override
    public synchronized int executeFindMax(ArrayList<Integer> list) {
        Integer i = Collections.max(list);
        System.out.println("Solved max of element and it is" + i);
        return i;
    }
}
