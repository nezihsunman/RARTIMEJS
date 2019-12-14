package main.java.executeStrategy;

import java.util.ArrayList;

public class RecursiveFindMax implements FindMaxExecudeStrategyInterface {

    @Override
    public int executeFindMax(ArrayList<Integer> list) {
        return list.get(0);
    }


    public static int findMaxRec(int A[], int n) {
        // if size = 0 means whole array
        // has been traversed
        if (n == 1)
            return A[0];

        return Math.max(A[n - 1], findMaxRec(A, n - 1));
    }
}
