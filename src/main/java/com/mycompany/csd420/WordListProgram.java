/*
 * Devinder Randhawa, 09/03/2023, Module 5 Assignment.
 * Java program that reads words from the "collection_of_words.txt" file,
 * displays all non-duplicate words in ascending order, and then in descending order.
 */

package com.mycompany.csd420;

/**
 *
 * @author devin
 */

    
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordListProgram {
    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";

        try {
            List<String> words = readWordsFromFile(fileName);
            Set<String> uniqueWords = new HashSet<>(words);

            // Sort the unique words in ascending order
            List<String> ascendingSortedWords = new ArrayList<>(uniqueWords);
            Collections.sort(ascendingSortedWords);

            // Sort the unique words in descending order
            List<String> descendingSortedWords = new ArrayList<>(uniqueWords);
            descendingSortedWords.sort(Collections.reverseOrder());

            // Display the sorted words
            System.out.println("Non-duplicate words in ascending order:");
            for (String word : ascendingSortedWords) {
                System.out.println(word);
            }

            System.out.println("\nNon-duplicate words in descending order:");
            for (String word : descendingSortedWords) {
                System.out.println(word);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static List<String> readWordsFromFile(String fileName) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using whitespace as a delimiter
                String[] lineWords = line.split("\\s+");
                words.addAll(Arrays.asList(lineWords));
            }
        }
        return words;
    }
}

