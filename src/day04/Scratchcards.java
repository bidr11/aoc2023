package day04;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static utils.Utils.*;


public class Scratchcards {
    static BufferedReader in;
    static String filename = "C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day04\\input";
    public static void main(String[] args) throws IOException {
        solve(new Part1());
        solve(new Part2());
    }

    public static void solve(Solver solver) throws IOException {
        in = new BufferedReader(new FileReader(filename));
        int ans = solver.solve();
        System.out.println(ans);
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

}
