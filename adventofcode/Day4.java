/*
 * This class solves both part of Day 4.
 */
package adventofcode;

import java.io.*;
import java.util.*;

/**
 *
 * @author phuoc
 */
public class Day4 {
    
    public static final int PARTONE = 1;
    public static final int PARTTWO = 2;
    
    private final int result1;
    private final int result2;
    
    /**
     * Constructs the Day 4 Solver.
     * @param input the input.
     * @throws IOException when input not found.
     */
    public Day4(File input) throws IOException {
        Scanner scanner = new Scanner(input);
        ArrayList<String> passphrase = new ArrayList<>();
        while (scanner.hasNextLine()) {
            passphrase.add(scanner.nextLine());
        }
        result1 = countPart1(passphrase);
        result2 = countPart2(passphrase);
    }
    
    /**
     * Prints out the result
     * @param part the part of the result to get.
     */
    public void printResult(int part) {
        System.out.printf("Day 4 part %d: ", part);
        switch (part) {
            case PARTONE:
                System.out.printf("%d\n", result1);
                break;
            case PARTTWO:
                System.out.printf("%d\n", result2);
                break;
            default:
                System.out.println("N/A\n");
                break;
        }
    }
    
    /**
     * Counts the number of lines that does not contain repeated words.
     * @param passphrase the input.
     * @return the count.
     */
    private int countPart1(List<String> passphrase) {
        int count = 0;
        outer:
        for (String pass: passphrase) {
            String[] words = pass.split(" ");
            Set<String> set = new HashSet<>();
            for (String word: words) {
                if (!set.add(word)) {
                    continue outer;
                }
            }
            count++;
        }
        return count;
    }
    
    /**
     * Counts lines that does not contain repeated words and anagrams.
     * @param passphrase the input.
     * @return the count.
     */
    private int countPart2(List<String> passphrase) {
        int count = 0;
        outer:
        for (String pass: passphrase) {
            String[] words = pass.split(" ");
            Set<String> set = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (i == j) { continue; }
                    if (isAnagram(words[i], words[j])) {
                        continue outer;
                    }
                 }
            }
            for (String word: words) {
                if (!set.add(word)) {
                    continue outer;
                }
            }
            count++;
        }
        return count;
    }
    
    /**
     * Checks if the two words contain the same character set arranged differently.
     * @param first the first word.
     * @param second the second word.
     * @return true if it is anagram, otherwise false.
     */
    private boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) { return false; }
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (second.contains(first.substring(i, i + 1))) {
                count++;
            }
        }
        return count == first.length();
    }
    
}
