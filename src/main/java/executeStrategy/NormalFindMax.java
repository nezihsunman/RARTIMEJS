package main.java.executeStrategy;

import java.util.ArrayList;

import static org.apache.commons.lang3.math.NumberUtils.min;

public class NormalFindMax implements FindMaxExecudeStrategyInterface {

    @Override
    public int executeFindMax(ArrayList<Integer> list) {
        System.out.println("Solving in execute finmax");

        return calculateMax(list);
    }

    private static int calculateMax(ArrayList<Integer> list) {
        int max;
        if (!list.isEmpty()) {
            max = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                if (max < list.get(i)) {
                    max = list.get(i);
                }
            }
            System.out.println("Solved max of element and it is " + max);
            return max;
        } else {
            System.out.println();
            return min();

        }
    }
}
