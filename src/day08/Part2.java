package day08;

import utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static day08.Main.in;
import static day08.Wasteland.getMap;

public class Part2 implements Utils.Solver<Long>{
    public Long solve() throws IOException {
        String sequence = in.readLine();
        int sequenceLength = sequence.length();
        Map<String,Utils.Pair<String,String>> map = getMap();

        List<String> currentPlaces = new ArrayList<>();
        for (String key : map.keySet()) {
            if (key.charAt(2) == 'A') {
                currentPlaces.add(key);
            }
        }

        int steps = 0;
        List<Long> endSteps = new ArrayList<>(currentPlaces.size());
        while (currentPlaces.stream().anyMatch(place -> place.charAt(2) != 'Z')) {
            List<String> newPlaces = new ArrayList<>();
            for (String current : currentPlaces) {
                Utils.Pair<String,String> pair = map.get(current);

                char currentDirection = sequence.charAt(steps % sequenceLength);
                String next = (currentDirection == 'L') ? pair.first : pair.second;

                if (next.charAt(2) == 'Z') {
                    endSteps.add((long) (steps + 1));
                } else {
                    newPlaces.add(next);
                }
            }
            currentPlaces = newPlaces;
            steps++;
        }

        return endSteps.stream().reduce(1L, Utils::lcm);
    }
}
