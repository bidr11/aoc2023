package day08;

import utils.Utils;

import java.io.IOException;
import java.util.Map;

import static day08.Main.in;
import static day08.Wasteland.getMap;

public class Part1 implements Utils.Solver<Integer>{
    public Integer solve() throws IOException {
        String sequence = in.readLine();
        int sequenceLength = sequence.length();
        Map<String,Utils.Pair<String,String>> map = getMap();

        int ans = 0;
        String current = "AAA";
        while (!current.equals("ZZZ")) {
            Utils.Pair<String,String> pair = map.get(current);

            char currentDirection = sequence.charAt(ans % sequenceLength);
            current = (currentDirection == 'L') ? pair.first : pair.second;

            ans++;
        }

        return ans;
    }
}
