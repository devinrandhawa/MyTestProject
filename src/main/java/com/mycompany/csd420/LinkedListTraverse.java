/*
 * Devinder Randhawa, 08/27/2023, Module 4 Assignment.
 * Test program in Java that stores 50,000 and 500,000 integers in LinkedList and test the
 * time to traverse the list using an iterator vs. using the get(index) method.
 */

package com.mycompany.csd420;

/**
 *
 * @author devin
 */



import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraverse {
    public static void main(String[] args) {
        int numElements1 = 50000;
        int numElements2 = 500000;

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        // Populate the lists with random integers
        for (int i = 0; i < numElements2; i++) {
            int value = (int) (Math.random() * 1000000);
            list1.add(value);
            list2.add(value);
        }

        // Test traversal time for list with 50,000 integers
        long startTime = System.nanoTime();
        traverseWithIterator(list1);
        long endTime = System.nanoTime();
        long iteratorTime1 = endTime - startTime;

        startTime = System.nanoTime();
        traverseWithGet(list1);
        endTime = System.nanoTime();
        long getTime1 = endTime - startTime;

        // Test traversal time for list with 500,000 integers
        startTime = System.nanoTime();
        traverseWithIterator(list2);
        endTime = System.nanoTime();
        long iteratorTime2 = endTime - startTime;

        startTime = System.nanoTime();
        traverseWithGet(list2);
        endTime = System.nanoTime();
        long getTime2 = endTime - startTime;

        // Print the results
        System.out.println("Traverse with Iterator (50,000): " + iteratorTime1 + " ns");
        System.out.println("Traverse with get(index) (50,000): " + getTime1 + " ns");
        System.out.println("Traverse with Iterator (500,000): " + iteratorTime2 + " ns");
        System.out.println("Traverse with get(index) (500,000): " + getTime2 + " ns");

        // Calculate and print time differences
        long iteratorDifference = Math.abs(iteratorTime2 - iteratorTime1);
        long getDifference = Math.abs(getTime2 - getTime1);
        System.out.println("Time difference using Iterator: " + iteratorDifference + " ns");
        System.out.println("Time difference using get(index): " + getDifference + " ns");

        // Explanation and discussion of results
        System.out.println("Results Explanation:");
        System.out.println("The iterator approach is expected to be faster than get(index) approach.");
        System.out.println("As the size of the list increases, the difference becomes more significant.");
        System.out.println("This is because the iterator maintains a reference to the current position,");
        System.out.println("resulting in a constant-time access, while get(index) has linear time complexity.");
    }

    public static void traverseWithIterator(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    public static void traverseWithGet(LinkedList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i);
        }
    }
}
