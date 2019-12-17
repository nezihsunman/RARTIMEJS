package main.java.executeStrategy;

import java.util.ArrayList;

public class BubbleSort implements SortExecudeStrategyInterface {

    //BubbleSort
    @Override
    public synchronized ArrayList<Integer> executeSort(ArrayList<Integer> list) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i+1, temp);
                    sorted = false;
                }
            }
        }
        return list;
    }
}
