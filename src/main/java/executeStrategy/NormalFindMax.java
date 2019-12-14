package main.java.executeStrategy;

import java.util.ArrayList;
import java.util.Collections;

public class NormalFindMax implements FindMaxExecudeStrategyInterface {

    @Override
    public int executeFindMax(ArrayList<Integer> list) {
        Integer i = Collections.max(list);
        return  i;
    }
}
