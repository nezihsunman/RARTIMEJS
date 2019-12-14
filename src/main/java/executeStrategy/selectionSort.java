package main.java.executeStrategy;

import java.util.ArrayList;

public class selectionSort implements SortExecudeStrategyInterface {

    //selection Sort
    @Override
    public ArrayList<Integer> executeSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int min = list.get(i);
            int minId = i;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j) < min) {
                    min = list.get(j);
                    minId = j;
                }
            }
            // swapping
            int temp = list.get(i);
            list.set(i, min);
            list.set(minId, temp);
        }

        return list;
    }
}
