/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csd420;

/**
 *
 * @author devin
 */


public class SumOfInputs {
    

    public static double m(int i) {
        if (i == 1) {
            return 1.0 / 2;
        } else {
            return i / (double)(i + 1) + m(i - 1);
        }
    }

    public static void main(String[] args) {
        int[] testCases = { 4, 9, 14 };

        for (int i : testCases) {
            double result = m(i);
            System.out.println("m(" + i + ") = " + result);
        }
    }
}

