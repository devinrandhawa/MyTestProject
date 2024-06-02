/*
 * Devinder Randhawa, 09/10/2023, Module 6 Assignment
 * Java Program displaying complete implementation of bubble sort with two generic methods
 * using the Comparable and Comparator interfaces, along with comments and test cases.
 */

package com.mycompany.csd420;

/**
 *
 * @author devin
 */

    

import java.util.Comparator;

public class BubbleSortExample {

    /**
     * This method sorts an array of elements using the Comparable interface.
     * The sorting is done in ascending order.
     * The list parameter is the array that needs to be sorted.
     * The <E> type parameter indicates that the elements in the array must 
     * implement the Comparable interface for comparisons.
     * The method uses the bubble sort algorithm, which repeatedly compares and 
     * swaps adjacent elements until the entire array is sorted.
     * The swapped flag is used to optimize the algorithm by detecting whether any 
     * swaps occurred during a pass through the array.
     * The method continues iterating and swapping elements until no more swaps are needed.
     * 
     */
    
    
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    
                    // Swap elements if they are out of order
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped); // Continue until no more swaps are needed
    }

    
    /**
     * This method sorts an array of elements using the Comparator interface.
     * The list parameter is the array that needs to be sorted.
     * The comparator parameter is used to compare elements for sorting.
     * The <E> type parameter indicates the type of elements in the array.
     * The method uses the bubble sort algorithm, similar to the Comparable-based method.
     * Comparison and swapping of elements are done according to the logic provided by the comparator.
     * The swapped flag is used to optimize the algorithm and determine 
     * whether any swaps occurred during a pass through the array.
     * The method continues iterating and swapping elements until no more swaps are needed.
     */
    
    
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (comparator.compare(list[i], list[i + 1]) > 0) {
                    
                    
                    // Swap elements if they are out of order
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped); // Continue until no more swaps are needed
    }

    
    public static void main(String[] args) {

        // Test sorting integers
        Integer[] intList = {9, 3, 2, 15, 6, 1, -2, 3, 23, 12};
        bubbleSort(intList);

        System.out.print("Sorted Integer Array: ");
        for (int i = 0; i < intList.length; i++) {
            System.out.print(intList[i] + " ");
        }
        System.out.println();

        
        // Test sorting strings ignoring case
        String[] strList = {"ABC", "abc", "apple", "Boy", "Apple", "banana", "nice", "niece"};
        bubbleSort(strList, String.CASE_INSENSITIVE_ORDER);

        System.out.print("Sorted String Array (Case-Insensitive): ");
        for (int i = 0; i < strList.length; i++) {
            System.out.print(strList[i] + " ");
        }
        System.out.println();
    }
}


