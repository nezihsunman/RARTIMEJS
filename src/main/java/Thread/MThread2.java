//package main.java.Thread;
//
//import main.java.Scheduler.Scheduler;
//
//public class MThread2 implements Runnable {
//    Scheduler jobs;
//    Thread t;
//
//    public MThread2(String thread, Scheduler scheduler) {
//        String name = thread;
//        t = new Thread(this, name);
//        System.out.println("New thread: " + t);
//        jobs = scheduler;
//        t.start();
//    }
//
//    @Override
//    public void run() {
//        try {
//            jobs.popFromQue();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
