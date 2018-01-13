/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ragos
 */
public class Arraylist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> depart = new ArrayList<>();
        ArrayList<String> fname = new ArrayList<>();
        ArrayList<String> lname = new ArrayList<>();
        ArrayList<String> department = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();
        String dep;
        String fn;
        String ln;
        String enter;
        String Dep;
        double average = 0;
        double allaverage = 0;
        int allmax = amount.get(0);
        int allmin = amount.get(0);
        int i = 0;
        int counter = 0;

        int salary;
        do {
            System.out.println("Please enter the department name or EXIT when you finish :");
            dep = input.nextLine().toUpperCase();

            while (dep.isEmpty()) {
                System.out.println("the department name could not be empty."
                        + "Please enter department name or EXIT when you finish :");
                dep = input.nextLine().toUpperCase();

            }
            depart.add(dep);
        } while (!dep.equals("EXIT"));

        depart.remove("EXIT");
        System.out.println(depart);
        do {
            System.out.println("please enter the employee first name :");
            fn = input.next();
            fname.add(fn);
            System.out.println("Please enter the employee last name :");
            ln = input.next();
            lname.add(ln);
            do {
                System.out.println("Please enter the employee salary :");
                salary = input.nextInt();

            } while (salary <= 0);
            amount.add(salary);
            do {
                System.out.println("Please enter department name :");
                Dep = input.next().toUpperCase();

            } while (!depart.contains(Dep));
            department.add(Dep);

            do {
                System.out.println("Do you want to enter another employee yes/no?");
                enter = input.next().toLowerCase();
            } while (!enter.equals("yes") && !enter.equals("no"));
        } while (enter.equals("yes"));

        System.out.println(fname);
        System.out.println(lname);
        System.out.println(amount);
        System.out.println(department);

        if (enter.equals("no")) {

            for (int all = 0; all < amount.size(); all++) {
                allaverage = allaverage + amount.get(all);
                if (all == 1 || amount.get(all) > allmax) {
                    allmax = amount.get(all);
                }
                if (all == 1 || amount.get(all) < allmin) {
                    allmin = amount.get(all);
                }
            }

            while (i < depart.size()) {
                int max = amount.get(0);
                int min = amount.get(0);
                for (int j = 0; j < department.size(); j++) {

                    if (department.get(j).contains(depart.get(i))) {

                        average = average + amount.get(j);
                        counter++;
                        if (j == 1 || amount.get(j) > max) {
                            max = amount.get(j);
                        }
                        if (j == 1 || amount.get(j) < max) {
                            min = amount.get(j);
                        }
                    }

                }

                System.out.println("Average Salary of " + depart.get(i) + " is :" + average / counter);
                System.out.println("Maximum Salary of " + depart.get(i) + " is :" + max);
                System.out.println("Minimum Salary of " + depart.get(i) + " is :" + min + '\n');

                average = 0;
                counter = 0;


                /* for (int k = 0; k < department.size(); k++) {
                    if (!depart.get(i).contains(department.get(k))) {
                        System.out.println("Average Salary of " + depart.get(i) + " is : NOT AVAILABLE");
                        System.out.println("Maximum Salary of " + depart.get(i) + " is :  NOT AVAILABLE");
                        System.out.println("Minimum Salary of " + depart.get(i) + " is : NOT AVAILABLE" + '\n');
                    }
                } */
                i++;
            }

            System.out.println("Average Salary of all departments is :" + allaverage / amount.size());
            System.out.println("Maximum Salary of all departments is :" + allmax);
            System.out.println("Minimum Salary of all departments is :" + allmin);

        }
    }
}
