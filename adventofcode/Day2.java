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
    
    private int checksum;
    
    /**
     * Constructs the Day 2 solver.
     * @param input the input file.
     * @throws IOException throws when file not found.
     */
    public Day2(File input) throws IOException {
        Scanner scanner = new Scanner(input);
        ArrayList<String[]> arr = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String i = scanner.nextLine();
            arr.add(i.split("\t"));
        }
        int min = 0;
        int max = 0;
        checksum = 0;
        for (String[] sarr: arr) {
            for (String element: sarr) {
                int num = Integer.parseInt(element);
                if (min == 0) { min = num; }
                if (min > num) { min = num; }
                if (max < num) { max = num; }
            }
            checksum += (max - min);
            // Reset min and max for next round.
            min = 0;
            max = 0;
        }
    }
    
    /**
     * Prints out the result.
     */
    public void printResult() {
        System.out.printf("Day 2 part 1: %d\n", checksum);
    }
    
}
