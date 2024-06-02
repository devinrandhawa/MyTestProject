/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

public class MyGame {
     public static void main(String[]args){
         
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("Enter a color: ");
        String color = userInput.nextLine();
        System.out.print("Enter a fruit: ");
        String fruit = userInput.nextLine();
        System.out.print("Enter a Hero: ");
        String hero = userInput.nextLine();
        
        System.out.println("Roses are " + color + " \n"
                + fruit + " are blue \n"
                + "I love " + hero);
        
     }
        
}
