/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.*;
import java.util.*;

/**
 *
 * @author phuoc
 */
public class Day4 {
    
    public Day4(File input) throws IOException {
        Scanner scanner = new Scanner(input);
        ArrayList<String> passphrase = new ArrayList<>();
        while (scanner.hasNextLine()) {
            passphrase.add(scanner.nextLine());
        }
        int count = 0;
        outer:
        for (String pass: passphrase) {
            System.out.println(pass);
            String[] words = pass.split(" ");
            Set<String> set = new HashSet<>();
            for (String word: words) {
                if (!set.add(word)) {
                    continue outer;
                }
            }
            count++;
            System.out.println(count);
        }
        System.out.println("End: " + count);
    }
    
}
