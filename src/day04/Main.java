package day04;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static utils.Utils.*;


public class Main {
    static BufferedReader in;
    static String filename = "C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day04\\input";
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader(filename));
        System.out.println(solve2());
    }
    public static int countMatches(String line) {
        int i = 0;
        i = skipUntil(line, i, value -> value == ':');

        Set<Integer> winningNumbers = new HashSet<>();

        while (i < line.length() && line.charAt(i) != '|') {
            i = skipUntil(line, i, Character::isDigit);

            Utils.Pair<Integer, Integer> result = nextInt(line, i);
            i = result.first;

            winningNumbers.add(result.second);
            i++;
        }

        int match = 0;
        while (i < line.length()) {
            i = skipUntil(line, i, Character::isDigit);

            Utils.Pair<Integer, Integer> result = nextInt(line, i);
            i = result.first;

            if (winningNumbers.contains(result.second))
                match++;

            i++;
        }
        return match;
    }

    public static int solve1() throws IOException {
        int res = 0;

        String line;
        while ((line = in.readLine()) != null) {
            int match = countMatches(line);
            res += 1 << match >> 1;
        }

        return res;
    }

    public static int solve2() throws IOException {
        String[] lines = readLines(in);
        int[] matches = new int[lines.length];
        Arrays.fill(matches, 1);

        for (int i = lines.length - 1; i >= 0; i--) {
            String line = lines[i];
            int match = countMatches(line);

            for (int j = i+1; j <= i + match; j++)
                matches[i] += matches[j];
        }

        return Arrays.stream(matches).sum();
    }

}
