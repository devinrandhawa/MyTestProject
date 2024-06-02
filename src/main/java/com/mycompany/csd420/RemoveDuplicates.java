/*
 * Devinder Randhawa, 08/27/2023, Module 3 Assignment.
 * Java Program containing a static method that returns a new ArrayList
 * containing all the original values with no duplicates from the original ArrayList.
 */

package com.mycompany.csd420;

/**
 *
 * @author devin
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class RemoveDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = generateRandomList(50, 1, 20);
        
        System.out.println("Original List:");
        System.out.println(originalList);
        
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);
        
        System.out.println("List with Duplicates Removed:");
        System.out.println(uniqueList);
    }
    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        Set<E> uniqueElements = new HashSet<>(list);
        return new ArrayList<>(uniqueElements);
    }
    
    public static ArrayList<Integer> generateRandomList(int size, int min, int max) {
        ArrayList<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            randomList.add(randomNumber);
        }
        
        return randomList;
    }
}

