package day01.part1;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    static FileInputStream in;
    public static void main(String[] args) throws IOException {
        in = new FileInputStream("C:\\Users\\bidr\\Desktop\\AdventOfCode2023\\src\\day01\\input");
        System.out.println(solve());
    }

    public static int solve() throws IOException {
        int res = 0;
        int firstDigit = -1, lastDigit = -1;

        int c;
        while ((c = in.read()) != -1) {

            if (Character.isDigit(c)) {
                if (firstDigit == -1)
                    firstDigit = c - '0';
                lastDigit = c - '0';
            }

            if (c == '\n') {
                res += firstDigit * 10 + lastDigit;
                firstDigit = -1;
            }

        }
        return res;
    }
}