package day04;

import utils.Utils;

import java.io.IOException;

import static day04.Scratchcards.*;

public class Part1 implements Utils.Solver {

    public int solve() throws IOException {
        int res = 0;

        String line;
        while ((line = in.readLine()) != null) {
            int match = countMatches(line);
            res += 1 << match >> 1;
        }

        return res;
    }
}
