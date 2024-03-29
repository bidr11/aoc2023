package day09;


import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Part1 implements Utils.Solver<Long>{
    public Long solve(BufferedReader in) throws IOException {
        String line;
        long ans = 0;
        while ((line = in.readLine()) != null) {
            List<Integer> sequence = Utils.extractNumbers(line);

            ans += Mirage.extrapolateForward(sequence) + sequence.get(sequence.size() - 1);
        }
        return ans;
    }
}

