/*
 * This class solves Day 5.
 */
package adventofcode;

import java.io.*;
import java.util.*;

/**
 *
 * @author phuoc
 */
public class Day5 {
    
    public final static int PARTONE = 1;
    public final static int PARTTWO = 2;
    
    private final int result1;
    private final int result2;
    
    /**
     * Constructs Day 5 solver.
     * @param input the input file.
     * @throws IOException when file not found.
     */
    public Day5(File input) throws IOException {
        Scanner scanner = new Scanner(input);
        ArrayList<Integer> instruction = new ArrayList<>();
        while (scanner.hasNextLine()) {
            instruction.add(Integer.valueOf(scanner.nextLine()));
        }
        ArrayList<Integer> input2 = new ArrayList<>(instruction);
        result1 = runInstruction1(instruction);
        result2 = runInstruction2(input2);
    }
    
    /**
     * Prints out the result
     * @param part the part of the result to get.
     */
    public void printResult(int part) {
        System.out.printf("Day 5 part %d: ", part);
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
     * Runs the instruction with the rule 1.
     * @param instruction the instruction.
     * @return number of steps to exit the instruction.
     */
    private int runInstruction1(List<Integer> instruction) {
        // count := steps to exit the instruction
        int count = 0;
        int index = 0;
        do {
            // currInt := current instruction.
            int currInt = instruction.get(index);
            // Increments the current instruction as requirement of the problem.
            instruction.set(index, currInt + 1);
            count++;
            // Calculates next index.
            index += currInt;
            // Exits instruction when index out of bound.
        } while (index < instruction.size());
        return count;
    }
    
    /**
     * Runs the instruction with the rule 2.
     * @param instruction the instruction.
     * @return number of steps to exit the instruction.
     */
    private int runInstruction2(List<Integer> instruction) {
        // count := steps to exit the instruction
        int count = 0;
        int index = 0;
        do {
            // currInt := current instruction.
            int currInt = instruction.get(index);
            // Modifies the current instruction as requirement of the problem.
            if (currInt >= 3) {
                instruction.set(index, currInt - 1);
            } else {
                instruction.set(index, currInt + 1);
            }
            count++;
            // Calculates next index.
            index += currInt;
            // Exits instruction when index out of bound.
        } while (index < instruction.size());
        return count;
    }
    
}
