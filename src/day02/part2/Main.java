package day02.part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader in;
    static String filename = "C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day02\\part2\\input";
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }
    public static void init() throws FileNotFoundException {
        in = new BufferedReader(new FileReader(filename));
    }
    public static int parse(String line) {
        int i = 0;
        while (line.charAt(i) != ':')
            i++;
        line = line.substring(i+2);

        Map<String, Integer> min_counts = new HashMap<>();
        String[] colors = line.split("(; |, )");
        for (String colorCount: colors) {
            int num = 0;
            for (int c = 0; c < colorCount.length(); c++) {
                if (Character.isDigit(colorCount.charAt(c))) {
                    num = num * 10 + colorCount.charAt(c) - '0';
                } else {
                    String col = colorCount.substring(c + 1);
                    if (num > min_counts.getOrDefault(col, 0))
                        min_counts.put(col, num);
                    break;
                }
            }
        }
        int ans = 1;
        for (int count : min_counts.values()) {
            ans *= count;
        }
        return ans;
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
