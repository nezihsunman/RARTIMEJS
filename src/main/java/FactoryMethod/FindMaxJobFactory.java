package main.java.FactoryMethod;

public class FindMaxJobFactory extends JobFactory {
    @Override
    protected AbstractJob createJob(String type) {
        if (type == "FindMaxJob")
            return new FindMaxJob();
        else
            return new FindMaxJob();
//            return new SortingJob;
    }
}
