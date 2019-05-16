/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.util.Scanner;

/**
 *
 * @author Jinkal Dudhat, 000762953
 */
public class Casino {

    /**
     * A method to test the object
     *
     * @param args unused
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Casino thisObj = new Casino();      //the casino to test
        thisObj.showMenu();

        // Create two objects for SlotMachine s1 and s2
        SlotMachine s1 = new SlotMachine();
        SlotMachine s2 = new SlotMachine();

        Scanner sc = new Scanner(System.in);  //scanner for get input from the user

        System.out.print("\n>");
        String str = sc.next();

        /**
         * method calls from the SlotMachine to generate output all the cases
         * give commands to perform operation
         */
        while (!str.equals("Q") && !str.equals("q")) {
            switch (str) {
                case "P1":
                case "p1":
                    s1.putQuarter();
                    break;

                case "P2":
                case "p2":
                    s2.putQuarter();
                    break;

                case "V1":
                case "v1":
                    s1.getReelValues();
                    break;

                case "V2":
                case "v2":
                    s2.getReelValues();
                    break;

                case "C1":
                case "c1":
                    System.out.println("$" + s1.getTotalCash());
                    break;

                case "C2":
                case "c2":
                    System.out.println("$" + s2.getTotalCash());
                    break;

                case "R1":
                case "r1":
                    s1.initializeSlotMachine();
                    System.out.println("Machine 1 reloaded");
                    break;

                case "R2":
                case "r2":
                    s2.initializeSlotMachine();
                    System.out.println("Machine 2 reloaded");
                    break;

                default:
                    System.out.println("Invalid Input. Try Again");
                    break;
            }

            // thisObj.showMenu();
            System.out.print("\n>");
            str = sc.next();
        }
        System.out.println("Goodbye!");
        sc.close();

    }

    public void showMenu() {
        System.out.println("P1 = Put a Quarter in Machine 1" + "\nP2 = Put a Quarter in Machine 2"
                + "\nV1 = View Machine 1" + "\nV2 = View Machine 2" + "\nC1 = Check Machine 1 cash"
                + "\nC2 = Check Machine 2 cash" + "\nR1 = Reload Machine 1" + "\nR2 = Reload Machine 2" + "\nQ = Quit");
    }
}
