package day06;

import utils.Utils;

import java.io.IOException;
import java.util.List;

import static day06.Main.in;
import static day06.WaitForIt.*;


public class Part1 implements Utils.Solver<Integer> {
        public Integer solve() throws IOException {
            int ans = 1;

            List<Integer> times = Utils.extractNumbers(in.readLine());
            List<Integer> distances = Utils.extractNumbers(in.readLine());

            for (int i = 0; i < times.size(); i++) {
                ans *= getWinnings(times.get(i), distances.get(i));
            }

            return ans;
        }
}
