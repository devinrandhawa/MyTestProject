/*
 * Devinder Randhawa, 08/12/2023, Module 1 Programming Assignment.
 * Java program to write data to file displaying an array of five random integers
 * A Date objective instance using the current date and an array of five random double values.
*/


package com.mycompany.csd420;


    
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class WriteDataToFile {
    public static void main(String[] args) {
        
        // Create a random number generator
        Random random = new Random();

        // Generate random integers
        int[] randomIntegers = new int[5];
        for (int i = 0; i < 5; i++) {
            randomIntegers[i] = random.nextInt(100) + 1;
        }

        // Get the current date
        Date currentDate = new Date();

        // Generate random doubles
        double[] randomDoubles = new double[5];
        for (int i = 0; i < 5; i++) {
            randomDoubles[i] = random.nextDouble() * 100.0;
        }

        // Specify the filename
        String filename = "Devinder_datafile.dat";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            
            // Write random integers to the file
            writer.write("Random Integers:");
            writer.newLine();
            for (int num : randomIntegers) {
                writer.write(String.valueOf(num));
                writer.newLine();
            }

            // Write current date to the file
            writer.write("Current Date:");
            writer.newLine();
            writer.write(currentDate.toString());
            writer.newLine();

            // Write random doubles to the file
            writer.write("Random Doubles:");
            writer.newLine();
            for (double num : randomDoubles) {
                writer.write(String.valueOf(num));
                writer.newLine();
            }

            System.out.println("Data has been written to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
