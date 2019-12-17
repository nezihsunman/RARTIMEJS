package test.java;

import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;
import main.java.Thread.ConsumeThread;
import main.java.Thread.ProduceThread;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CommandClient {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    private static int uniqueIdforNodeOperation = 0;
    private static ArrayList<Node> nodeList = new ArrayList<Node>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Write your command");
            System.out.println("For generate the job please enter 1");
            System.out.println("For starting the quick test please enter 2");
            System.out.println("For Generate the nodeServer with spesific core please enter 3");
            System.out.println("For Start the nodeServer with already generated please enter 4");
            System.out.println("For Stop the nodeServer with already generated please enter 5");
            System.out.println("For Exit please enter * ");
            System.out.println("Please enter Value");
            String value = in.nextLine();

            if (value.equals("1")) {
                System.out.println("If you want to generate findMaxJob please Enter 1");
                System.out.println("If you want to generate sortingJob please Enter 2");
                System.out.println("Pleaseeee enterrr Valueee for JOB Type");
                String inValue = in.nextLine();
                if (inValue.equals("1")) {
                    takeArraylist();
                    //call command
                } else if (inValue.equals("2")) {
                    takeArraylist();
                    //call command and generate
                }
            }
            if (value.equals("2")) {

                //Generate Test
            }
            if (value.equals("3")) {
                System.out.println("Please enter core number as a integer");
                try {
                    int coreNumber = in.nextInt();
                    Node node = new Node(coreNumber);
                    System.out.println("Your unuqie id is equal to :");
                    int uniqueID = getUniqueId();

                    System.out.println("if you want to start server operation please enter 10");

                    System.out.println("if you want to start server later please enter 11 end we will give you a unique id ");
                    int serverOp = -1;
                    try {
                        serverOp = in.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Valid number Next Time");
                    }

                    if (serverOp == 10) {
                        node.nodeStartThread();
                    }

                    System.out.println(uniqueID);
                    if (serverOp == 11) {

                        nodeList.add(uniqueIdforNodeOperation, node);

                    }
                } catch (Exception e) {
                    System.out.println("Please enter number");
                }


            }
            if (value.equals("4")) {
                try {
                    int nodeID = in.nextInt();
                    if (nodeList.get(nodeID) != null) {
                        Node tempNode = nodeList.get(nodeID);
                        tempNode.nodeStartThread();
                    } else {
                        System.out.println("Your ID is wrong");
                    }

                } catch (Exception e) {
                    System.out.println("please enter true value");
                }

            }
            if (value.equals("5")) {
                try {
                    int nodeID = in.nextInt();
                    if (nodeList.get(nodeID) != null) {
                        Node tempNode = nodeList.get(nodeID);
                        tempNode.nodeStartThread();
                    } else {
                        System.out.println("Your ID is wrong");
                    }

                } catch (Exception e) {
                    System.out.println("please enter true value");
                }
            }
            if(value.equals("*")) {
                break;
            }


        }

    }

    public static void takeArraylist() {
        Scanner in = new Scanner(System.in);
        System.out.println("if you want to exit press enter Integer (*) ");
        while (true) {
            String b = in.nextLine();
            if (b.equals("*")) {
                break;
            }
            try {
                int c = Integer.parseInt(b);
                list.add(c);
                System.out.println("You entered int " + b);
            } catch (Exception e) {

                e.printStackTrace();
            }


        }
    }

    public static void generateTest() {
        NewScheduler s = new NewScheduler();

        ProduceThread produceThread = new ProduceThread(s);
        ConsumeThread consumeThread = new ConsumeThread(s);

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(produceThread, 0, 1, TimeUnit.SECONDS);
        exec.scheduleAtFixedRate(consumeThread, 0, 1, TimeUnit.SECONDS);
    }

    public static synchronized int getUniqueId() {
        return uniqueIdforNodeOperation++;
    }
}
