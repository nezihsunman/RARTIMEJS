package test.java;

import main.java.AbstractJobFactory.AbstractJobFactory;
import main.java.AbstractJobFactory.FindMaxJobFactory;
import main.java.SingletonJobQueue.JobQueue;
import main.java.Threads.ProducerConsumer;
import org.junit.Assert;
import org.junit.Test;


public class ProducerConsumerTests {

    @Test
    public void test_Should_Create_Array_Of_Integers() throws InterruptedException {
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
    }

