/*
 * Devinder Randhawa, 09/17/2023, Module 8 Assignment.
 * Java class that uses three threads to output random characters, digits,
 * and special characters to a text area for display. This class generates
 * a minimum of 10,000 characters of each type.
 */
package com.mycompany.csd420;

/**
 *
 * @author devin
 */

   
import java.lang.Math;

public class DevinderThreeThreads {

    public static void main(String[] args) {

        Runnable run = () -> {
            long startTime = System.currentTimeMillis();
            System.out.println("Thread 1: Generating random letters...");
            for (int i = 0; i <= 10000; i++) {
                System.out.print((char) getRandomLetter());
                System.out.flush(); // Flush the output to the console
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("\nThread 1 Finish: Generated random letters in " + elapsedTime + " milliseconds");
        };

        Runnable run2 = () -> {
            long startTime = System.currentTimeMillis();
            System.out.println("Thread 2: Generating random digits...");
            for (int i = 0; i <= 10000; i++) {
                System.out.print(getRandomNumber());
                System.out.flush(); // Flush the output to the console
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("\nThread 2 Finish: Generated random digits in " + elapsedTime + " milliseconds");
        };

        Runnable run3 = () -> {
            long startTime = System.currentTimeMillis();
            System.out.println("Thread 3: Generating random special characters...");
            for (int i = 0; i <= 10000; i++) {
                System.out.print((char) getRandomSpecial());
                System.out.flush(); // Flush the output to the console
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("\nThread 3 Finish: Generated random special characters in " + elapsedTime + " milliseconds");
        };

        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run2);
        Thread thread3 = new Thread(run3);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static int getRandomLetter() {
        // return the ASCII code for a lowercase letter
        return (int) (Math.random() * 26 + 97);
    }

    private static int getRandomNumber() {
        // return a random digit between 0 and 9
        return (int) (Math.random() * 10);
    }

    private static int getRandomSpecial() {
        // return the ASCII code for a random special character

        // create an array of the special character ASCII codes
        int[] chars = {33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 64, 91, 92, 93,
                94, 95, 96, 123, 124, 125, 126};

        return chars[(int) (Math.random() * chars.length)];
    }
}
