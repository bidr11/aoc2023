package day05;

import utils.Utils;

import java.io.IOException;

import static day05.Main.in;
import static utils.Utils.readLines;

public class Part2 implements Utils.Solver {
    public Object solve() throws IOException {
        String[] lines = readLines(in);
//        int[] matches = new int[lines.length];
//        Arrays.fill(matches, 1);

        for (int i = lines.length - 1; i >= 0; i--) {
            String line = lines[i];
//            int match = countMatches(line);
//
//            for (int j = i+1; j <= i + match; j++)
//                matches[i] += matches[j];
        }

//        return Arrays.stream(matches).sum();
        return 0;
    }
}