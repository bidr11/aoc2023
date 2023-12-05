package day02.part2;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader in;
    static String filename = "C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day02\\input";
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader(filename));
        System.out.println(solve());
    }
    public static Collection<Integer> parse(String line) {
        Map<Character,Integer> min_counts = new HashMap<>();
        int i = 0;
        i = Utils.skipUntil(line, i, c -> c == ':');

        while (i < line.length()) {
            i = Utils.skipUntil(line, i, Character::isDigit);

            Utils.Pair<Integer, Integer> result = Utils.nextInt(line, i);
            i = result.first + 1;
            int number = result.second;

            if (number > min_counts.getOrDefault(line.charAt(i), 0))
                min_counts.put(line.charAt(i), number);

            i = Utils.skipUntil(line, i, c -> c == ';' || c == ',');
        }
        return min_counts.values();

    }

    public static int solve() throws IOException {
        int res = 0;

        String line;
        while ((line = in.readLine()) != null) {
            res += parse(line).stream().reduce(1, (a,b) -> a * b);
        }

        return res;
    }
}
