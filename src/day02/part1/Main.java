package day02.part1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader in;
    static String filename = "C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day02\\part1\\input";
    static Map<String, Integer> MAX_COUNTS = new HashMap<>();
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }
    public static void init() throws FileNotFoundException {
        in = new BufferedReader(new FileReader(filename));
        MAX_COUNTS.put("red", 12);
        MAX_COUNTS.put("green", 13);
        MAX_COUNTS.put("blue", 14);
    }
    public static boolean parse(String line) {
        int i = 0;
        while (line.charAt(i) != ':')
            i++;
        line = line.substring(i+2);

        String[] colors = line.split("(; |, )");
        for (String colorCount: colors) {
            int num = 0;
            for (int c = 0; c < colorCount.length(); c++) {
                if (Character.isDigit(colorCount.charAt(c))) {
                    num = num * 10 + colorCount.charAt(c) - '0';
                } else {
                    String col = colorCount.substring(c + 1);
                    if (num > MAX_COUNTS.get(col)) {
                        return false;
                    }
                    break;
                }
            }
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
