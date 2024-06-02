/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

public class MyInput {
    public static void main(String[]args){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String name = userInput.nextLine();
        
        System.out.print("Enter Your Age: ");
        int age = userInput.nextInt();
        System.out.println("Hello " + name + ", You are " + age + " Years's old");
    }
}
