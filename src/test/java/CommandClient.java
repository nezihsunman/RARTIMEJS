package test.java;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandClient {
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Write your command");
            System.out.println("For generate the job please enter 1");
            System.out.println("For starting the quick test please enter 2");
            System.out.println("For Generate the node with spesific core please enter 3");
            System.out.println("Pleaseeee enterrr Valueee");
            String value = in.nextLine();

            if (value.equals("1")) {
                System.out.println("If you want to generate findMaxJob please Enter 1");
                System.out.println("If you want to generate sortingJob please Enter 2");
                System.out.println("Pleaseeee enterrr Valueee");
                value = in.nextLine();
                if (value.equals("1")) {
                    takeArraylist();
                    //call command
                } else if (value.equals("2")) {
                    takeArraylist();
                    //call command and generate
                }
            }
            if (value.equals("2")) {
                //Generate Test
            }
            if (value.equals("3")) {
                //Generate Node

            }

            String s = in.nextLine();
            System.out.println("You entered string " + s);

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
}
