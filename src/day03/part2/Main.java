package day03.part2;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader in;
    static String filename = "C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day03\\input";
    static Queue<Map<Integer, Utils.Pair<Integer,Integer>>> symbolIndices = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader(filename));
        System.out.println(solve());
    }
    public static void isValid(int startIndex, int endIndex, Map.Entry<Integer, Utils.Pair<Integer,Integer>> entry, int number) {
        int validLeft = startIndex - 1, validRight = endIndex + 1;
        if (validLeft > entry.getKey() || entry.getKey() > validRight)
            return;

        Utils.Pair<Integer,Integer> pair = entry.getValue();
        if (pair.first == -1 && pair.second == -1)
            pair.first = number;
        else if (pair.second == -1)
            pair.second = number;
        else if (pair.first != -1)
            pair.first = -1;

    }
    public static void parseSymbols(String line) {
        if (symbolIndices.size() > 2)
            symbolIndices.poll();

        Map<Integer, Utils.Pair<Integer,Integer>> lineSymbols = new HashMap<>(); // index: {number1, number2}
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '*')
                lineSymbols.put(i, new Utils.Pair<>(-1 ,-1));
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
            for (Map<Integer, Utils.Pair<Integer,Integer>> lineSymbols: symbolIndices) {
                if (lineSymbols == null)
                    continue;

                for (Map.Entry<Integer,Utils.Pair<Integer,Integer>> entry: lineSymbols.entrySet()){
                    isValid(start, end, entry, number);
                }

                for (Utils.Pair<Integer,Integer> pair : lineSymbols.values()) {
                    if (pair.first != -1 && pair.second != -1) {
                        res += pair.first * pair.second;
                        pair.first = pair.second = -1;
                    }
                }
            }
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

