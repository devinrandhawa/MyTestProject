/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

public class Calculator {
     public static void main(String[]args){
         
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter in First Number: ");
        double num1 = userInput.nextDouble();
        
        System.out.print("Enter in the second Number: ");
        double num2 = userInput.nextDouble();
        System.out.println("Your Number is: " + (num1 + num2));
    }
}
    

