/*
 * This class solves both part of Day 2.
 */
package adventofcode;

import java.io.*;
import java.util.*;

/**
 *
 * @author phuoc
 */
public class Day2 {
    
    public static final int PARTONE = 1;
    public static final int PARTTWO = 2;
    
    private final int checksum1;
    private final int checksum2;
    
    /**
     * Constructs the Day 2 solver.
     * @param input the input file.
     * @throws IOException throws when file not found.
     */
    public Day2(File input) throws IOException {
        // Scans the input and puts it in a 2D list.
        Scanner scanner = new Scanner(input);
        ArrayList<String[]> arr = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String i = scanner.nextLine();
            arr.add(i.split("\t"));
        }
        checksum1 = getChecksum1(arr);
        checksum2 = getChecksum2(arr);
    }
    
    /**
     * Computes the checksum of the list input.
     * Checksum equals sum of difference of max and min of each line.
     * @param arr the 2D list of Integer-parse compatible.
     * @return checksum
     */
    private int getChecksum1(List<String[]> arr) {
        int min = 0;
        int max = 0;
        int temp = 0;
        for (String[] sarr: arr) {
            for (String element: sarr) {
                int num = Integer.parseInt(element);
                if (min == 0) { min = num; }
                if (min > num) { min = num; }
                if (max < num) { max = num; }
            }
            temp += (max - min);
            // Reset min and max for next round.
            min = 0;
            max = 0;
        }
        return temp;
    }
    
    /**
     * Computes the checksum of the list input.
     * Checksum equals sum of the only two evenly divide numbers of each line.
     * @param arr the 2D list of Integer-parse compatible.
     * @return checksum
     */
    private int getChecksum2(List<String[]> arr) {
        // NOTE: This is bad algorithm with complexity up to O(n^3).
        // There should be a better way to do this.
        int temp = 0;
        for (String[] sarr: arr) {
            for (String e1: sarr) {
                int num = Integer.parseInt(e1);
                for (String e2: sarr) {
                    int num2 = Integer.parseInt(e2);
                    if (num > num2 && num % num2 == 0) {
                        temp += (num / num2);
                        break;
                    }
                }
            }
        }
        return temp;
    }
    
    /**
     * Prints out the result.
     * @param part the part to print.
     */
    public void printResult(int part) {
        System.out.printf("Day 2 part %d: ", part);
        switch (part) {
            case PARTONE:
                System.out.printf("%d\n", checksum1);
                break;
            case PARTTWO:
                System.out.printf("%d\n", checksum2);
                break;
            default:
                System.out.println("N/A\n");
                break;
        }
    }
    
}
