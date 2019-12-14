package main.java.AbstractJobFactory;

import main.java.Jobs.AbstractJob;
import main.java.Jobs.FindMaxJob;

public class FindMaxJobFactory extends Thread implements AbstractJobFactory {
    @Override
    public AbstractJob getJob() {
        return new FindMaxJob();
    }

    @Override
    public ClassLoader getContextClassLoader() {
        return super.getContextClassLoader();
    }
}
//public class FindMaxJobFactory implements AbstractJobFactory, Runnable {
////public class FindMaxJobFactory implements AbstractJobFactory {
//
//    private JobQueue q = JobQueue.getSingletonInstance();
//
//    @Override
//    public AbstractJob getJob() {
//        Random random = new Random();
//        return new FindMaxJob(random.nextInt(50));
//    }
//
////    public void add()
//
//    @Override
//    public void run() {
//        //replaced with in every random second
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Created a new job");
//            AbstractJob J = getJob();
//            q.add(J);
//            System.out.println("Added job to PriorityQueue");
//        }
//        // consumer get items
////            q.get();
//    }
//}
