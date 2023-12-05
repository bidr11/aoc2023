package day03.part1;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader in;
    static String filename = "C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day03\\input";
    static Queue<List> symbolIndices = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader(filename));
        System.out.println(solve());
    }
    public static boolean isValid(int startIndex, int endIndex) {
        int validLeft = startIndex - 1, validRight = endIndex + 1;
        for (List<Integer> lineSymbols: symbolIndices) {
            for (int symbolIndex: lineSymbols) {
                if (validLeft <= symbolIndex && symbolIndex <= validRight)
                    return true;
            }
        }
        return false;
    }
    public static void parseSymbols(String line) {
        if (symbolIndices.size() > 2)
            symbolIndices.poll();

        List<Integer> lineSymbols = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i)) || line.charAt(i) == '.')
                continue;
            lineSymbols.add(i);
        }
        symbolIndices.add(lineSymbols);
    }
    public static int parseNumbers(String line) {
        int res = 0;

        int i = 0;
        while (i < line.length()) {
            int start, end;
            int number;

            // continue until you find a digit
            i = start = Utils.skipUntil(line, i, Character::isDigit);
            if (i == line.length())
                break;

            // if digit found, keep parsing until no more digits are found
            Utils.Pair<Integer,Integer> result = Utils.nextInt(line, i);
            i = result.first;
            end = i - 1;
            number = result.second;

            // check if the number is valid (adjacent to symbol)
            if (isValid(start, end))
                res += number;
        }
        return res;
    }

    public static int solve() throws IOException {
        int res = 0;
        ArrayList<String> lines = new ArrayList<>();

        String line = in.readLine();
        lines.add("");
        lines.add(line);
        parseSymbols(line);
        while ((line = in.readLine()) != null) {
            parseSymbols(line);
            res += parseNumbers(lines.get(1));
            lines.add(line) ;
            lines.remove(0);
        }

        res += parseNumbers(lines.get(1));


        return res;
    }
}
