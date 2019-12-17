package main.java.executeStrategy;

import java.util.ArrayList;

public class RecursiveFindMax implements FindMaxExecudeStrategyInterface {

    @Override
    public int executeFindMax(ArrayList<Integer> list) {
        return findMaxRec(list, list.size());
    }


    public int findMaxRec(ArrayList<Integer> list, int n) {
        if (n == 1)
            return list.get(0);

        return Math.max(list.get(n - 1), findMaxRec(list, n - 1));
    }
}
