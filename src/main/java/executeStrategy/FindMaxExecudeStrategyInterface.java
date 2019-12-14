package main.java.executeStrategy;

public interface FindMaxExecudeStrategyInterface {
    void execute();

}

class RecursiveFindMax implements FindMaxExecudeStrategyInterface {

    @Override
    public void execute() {

    }
    public static int findMaxRec(int A[], int n)
    {
        // if size = 0 means whole array
        // has been traversed
        if(n == 1)
            return A[0];

        return Math.max(A[n-1], findMaxRec(A, n-1));
    }
}
class NormalFindMax implements FindMaxExecudeStrategyInterface {

    @Override
    public void execute() {

    }
}