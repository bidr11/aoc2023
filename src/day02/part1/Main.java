package day02.part1;

import utils.Utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader in;
    static String filename = "C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day02\\input";
    static Map<Character, Integer> MAX_COUNTS = new HashMap<>();
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }
    public static void init() throws FileNotFoundException {
        in = new BufferedReader(new FileReader(filename));
        MAX_COUNTS.put('r', 12);
        MAX_COUNTS.put('g', 13);
        MAX_COUNTS.put('b', 14);
    }
    public static boolean parse(String line) {
        int i = 0;
        i = Utils.skipUntil(line, i, c -> c == ':');

        while (i < line.length()) {
            i = Utils.skipUntil(line, i, Character::isDigit);

            Utils.Pair<Integer, Integer> result = Utils.nextInt(line, i);
            i = result.first + 1;
            int number = result.second;

            if (number > MAX_COUNTS.get(line.charAt(i)))
                return false;

            i = Utils.skipUntil(line, i, c -> c == ';' || c == ',');
        }
        return true;
    }

    public static int solve() throws IOException {
        int res = 0;
        int lineCount = 1;

        String line;
        while ((line = in.readLine()) != null) {
            res += (parse(line) ? lineCount : 0);
            lineCount++;
        }

        return res;
    }
}
