/* 
 * This class solves both parts of Day 1.
 */

package adventofcode;

/**
 *
 * @author phuoc
 */
public class Day1 {
    
    public final static int PARTONE = 1;
    public final static int PARTTWO = 2;
    
    private final int result1;
    private final int result2;
    
    /**
     * Constructs the day1 solver.
     * @param input the string input.
     */
    public Day1(String input) {
        result1 = count1(input);
        result2 = count2(input);
    }
    
    /**
     * Prints out the result
     * @param part the part of the result to get.
     */
    public void printResult(int part) {
        System.out.printf("Day 1 part %d: ", part);
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
     * Computes part one.
     * @param string the input.
     * @return the result.
     */
    private int count1(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (i + 1 >= string.length()) { break; }
            if (string.charAt(i) == string.charAt(i + 1)) {
                count += Integer.parseInt(string.substring(i, i + 1));
            }
        }
        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            count += Integer.parseInt(string.substring(0, 1));
        }
        return count;
    }

    /**
     * Computes part two.
     * @param string the input.
     * @return the result.
     */
    private int count2(String string) {
        int count = 0;
        int mid = string.length() / 2;
        for (int i = 0; i < string.length(); i++) {
            int compareIndex = i + mid;
            if (compareIndex >= string.length()) { 
                compareIndex = compareIndex - string.length();
            }
            if (string.charAt(i) == string.charAt(compareIndex)) {
                count += Integer.parseInt(string.substring(i, i + 1));
            }
        }
        return count;
    }
    
}
