package day04;

import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;


public class Part1 implements Utils.Solver<Integer> {

    public Integer solve(BufferedReader in) throws IOException {
        int res = 0;

        String line;
        while ((line = in.readLine()) != null) {
            int match = Scratchcards.countMatches(line);
            res += 1 << match >> 1;
        }

        return res;
    }
}
