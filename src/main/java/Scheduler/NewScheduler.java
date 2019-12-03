package main.java.Scheduler;

import main.java.Node.Node;
import main.java.Node.Observer;
import main.java.Threads.ProducerConsumer;

public class NewScheduler implements Observer{
    public NewScheduler() throws InterruptedException{
        final ProducerConsumer pc = new ProducerConsumer();
        Thread producerThread  = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                }

                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }


    @Override
    public void onObservableChanged(Node n) throws InterruptedException {


    }
}
