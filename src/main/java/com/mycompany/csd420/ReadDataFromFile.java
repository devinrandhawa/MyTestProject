/*
 * Devinder Randhawa, 08/12/2023, Module 1 Programming Assignment.
 * Java program to write data to file displaying an array of five random integers
 * A Date objective instance using the current date and an array of five random double values.
 */


package com.mycompany.csd420;

/**
 *
 * @author devin
 */

    

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromFile {
    public static void main(String[] args) {
        
        // Specify the filename
        String filename = "Devinder_datafile.dat";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            // Read each line from the file until the end
            while ((line = reader.readLine()) != null) {
                
                // Print the current line to the console
                System.out.println(line);
            }
            
            // Display a message indicating successful data reading
            System.out.println("Data has been read from " + filename);
        } catch (IOException e) {
            
            // Print the exception details if an error occurs
            e.printStackTrace();
        }
    }
}
