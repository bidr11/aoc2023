package day06;

import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static day06.WaitForIt.*;


public class Part1 implements Utils.Solver<Integer> {
        public Integer solve(BufferedReader in) throws IOException {
            int ans = 1;

            List<Integer> times = Utils.extractNumbers(in.readLine());
            List<Integer> distances = Utils.extractNumbers(in.readLine());

            for (int i = 0; i < times.size(); i++) {
                ans *= (int) getWinnings(times.get(i), distances.get(i));
            }

            return ans;
        }
}
