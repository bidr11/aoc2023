package day01.part2;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static BufferedReader in;
    static String filename = "C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day01\\input";
    static String[] digits = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader(filename));
        System.out.println(solve());
    }

    public static int longestMatch(String line, String substring, int start) {
        int j = 0;
        while (j < substring.length() && start + j < line.length() && substring.charAt(j) == line.charAt(start + j)) {
            j++;
        }
        return j;
    }

    public static int parse(String line) {
        Utils.Pair<Integer,Integer> left = new Utils.Pair<>(-1, Integer.MAX_VALUE);
        Utils.Pair<Integer,Integer> right = new Utils.Pair<>(-1, Integer.MAX_VALUE);

        for (int d = 0; d < digits.length; d++) {
            int i = 0;
            while (i < line.length()) {
                int j = longestMatch(line, digits[d], i);
                if (j == digits[d].length()) {
                    if (left.second > i) {
                        left.first = d + 1;
                        left.second = i;
                    }
                    if (right.second < i) {
                        right.first = d + 1;
                        right.second = i;
                    }
                }

                if (j == 0)
                    i++;
                else i += j;
            }
        }

        int i = 0;
        while (i < line.length()) {
            if (Character.isDigit(line.charAt(i))) {
                if (left.second > i) {
                    left.first = line.charAt(i) - '0';
                    left.second = i;
                }
                if (right.second < i) {
                    right.first = line.charAt(i) - '0';
                    right.second = i;
                }
            }
            i++;
        }

        return left.first * 10 + right.second;

    }

    public static int solve() throws IOException {
        int res = 0;

        String line;
        while ((line = in.readLine()) != null) {
            res += parse(line);
        }

        return res;
    }
}