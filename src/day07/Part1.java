package day07;

import utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static day07.CamelCards.handAndBet;
import static day07.Main.in;


public class Part1 implements Utils.Solver<Integer> {
        public Integer solve() throws IOException {
            List<Utils.Pair<Long,Integer>> hands = new ArrayList<>();
            int ans = 0;

            String line;
            while ((line = in.readLine()) != null) {
                hands.add(handAndBet(line));
            }
            hands.sort(Comparator.comparingLong(a -> a.first));

            for (int rank = 0; rank < hands.size(); rank++) {
                int bet = hands.get(rank).second;
                ans += bet * (rank + 1);
            }

            return ans;
        }
}
