package main.java;

import main.java.Node.Node;
import main.java.Scheduler.NewScheduler;
import main.java.Thread.ConsumeThread;
import main.java.Thread.ProduceThread;
import main.java.command.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Gui{
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    static ArrayList<Integer> list = new ArrayList<Integer>();
    private static int uniqueIdforNodeOperation = 0;
    private static ArrayList<Node> nodeList = new ArrayList<Node>();
    private NewScheduler scheduler = new NewScheduler();
    private Command producerCommand;

    public static void main(String args[]) {
        Gui gui=new Gui();
    }
    public Gui() {
        run();
    }

    public void run() {
        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println(ANSI_BLUE + "Write your command");
            System.out.println(ANSI_BLUE + "For Generate the job please enter 1");

            System.out.println(ANSI_BLUE + "For Generate the nodeServer with spesific core please enter 3");
            System.out.println(ANSI_BLUE + "For Start the nodeServer with already generated please enter 4");
            System.out.println(ANSI_BLUE + "For Stop the nodeServer with already generated please enter 5");
            System.out.println(ANSI_BLUE + "For Start Random Generated Test Job to Queue from scheduler please enter 6");
            System.out.println(ANSI_BLUE + "For Stop Random Generated Test Job to Queue from scheduler please enter 7");
            System.out.println(ANSI_BLUE + "For Start consume from Queue from scheduler please enter 8");
            System.out.println(ANSI_BLUE + "For Starting the Integrated test please enter 10");
            System.out.println(ANSI_BLUE + "For Exit please enter * ");
            System.out.println(ANSI_BLUE + "Please enter Value");
            String value = in.nextLine();

            if (value.equals("1")) {
                this.generateJob();
            } else if (value.equals("3")) {
                this.createNodeWithSpesificCore();
            } else if (value.equals("4")) {
                this.startNodeServer();
            } else if (value.equals("5")) {
                this.stopNodeServer();
            } else if (value.equals("6")) {
                producerCommand = new ProducerCommand(this.scheduler);
                producerCommand.takeCommand();
            } else if (value.equals("7")) {
                StopCommand stopCommand = (StopCommand) producerCommand;
                stopCommand.stopCommand();
            } else if (value.equals("8")) {
                Command command = new ConsumerCommand(this.scheduler);
                command.takeCommand();
            } else if (value.equals("10")) {
                this.generateTest();
            }


            if (value.equals("*")) {
                break;
            }


        }

    }

    public ArrayList<Integer> takeArraylist() {
        Scanner in = new Scanner(System.in);
        System.out.println("if you want to exit press enter Integer (*) ");
        ArrayList<Integer> takingListfromUser = new ArrayList<Integer>();
        while (true) {
            String b = in.nextLine();
            if (b.equals("*")) {
                break;
            }
            try {
                int c = Integer.parseInt(b);
                takingListfromUser.add(c);
                System.out.println("You entered int " + b);
            } catch (Exception e) {
                System.out.println("Please write integer value");
            }
        }
        return takingListfromUser;
    }

    public void generateTest() {

        ProduceThread produceThread = new ProduceThread(scheduler);
        ConsumeThread consumeThread = new ConsumeThread(scheduler);

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(produceThread, 0, 1, TimeUnit.SECONDS);
        exec.scheduleAtFixedRate(consumeThread, 0, 1, TimeUnit.SECONDS);

        Node n = new Node(4);
        n.registerObserver(this.scheduler);
        n.nodeStartThread();
        System.out.println(ANSI_GREEN + "Test START and Code Block is Finished");
    }

    public void generateJob() {
        System.out.println("If you want to generate findMaxJob please Enter 1");
        System.out.println("If you want to generate sortingJob please Enter 2");
        System.out.println("Pleaseeee enterrr Valueee for JOB Type");
        Scanner in = new Scanner(System.in);
        String inValue = in.nextLine();
        if (inValue.equals("1")) {
            Command command = new GenerateFindMaxJobCommandtoQueue(takeArraylist());
            command.takeCommand();
            //call command
        } else if (inValue.equals("2")) {
            Command command = new GenerateSortingJobCommandtoQueue(takeArraylist());
            command.takeCommand();
        }
    }

    public void createNodeWithSpesificCore() {
        System.out.println("Please enter core number as a integer");
        try {
            Scanner in = new Scanner(System.in);
            int coreNumber = in.nextInt();
            Node node = new Node(coreNumber);
            node.registerObserver(this.scheduler);

            int uniqueID = getUniqueId();
            System.out.println("Your unuqie id is equal to :" + uniqueID);
            System.out.println("if you want to start server operation please enter 10");
            System.out.println("if you want to start server later please go main page end enter 4 with a unique id ");
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
            nodeList.add(uniqueID, node);

        } catch (Exception e) {
            System.out.println("Please enter number");
        }


    }

    public void startNodeServer() {
        try {
            Scanner in = new Scanner(System.in);
            int nodeID = in.nextInt();
            if (nodeList.get(nodeID) != null) {
                Node tempNode = nodeList.get(nodeID);
                tempNode.nodeStartThread();
            } else {
                System.out.println("Your ID is wrong");
            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!Please enter Correct ID value!!!!!!!!!!!!");
        }
    }

    public void stopNodeServer() {
        try {
            Scanner in = new Scanner(System.in);
            int nodeID = in.nextInt();
            if (nodeList.get(nodeID) != null) {
                Node tempNode = nodeList.get(nodeID);
                tempNode = null;
                nodeList.set(nodeID, null);
            } else {
                System.out.println("Your ID is wrong");
            }

        } catch (Exception e) {
            System.out.println("please enter true value");
        }
    }

    public static synchronized int getUniqueId() {
        return uniqueIdforNodeOperation++;
    }
}
