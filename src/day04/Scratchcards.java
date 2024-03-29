package day04;

import utils.Utils;

import java.util.HashSet;
import java.util.Set;

import static utils.Utils.*;


public class Scratchcards {
    public static int countMatches(String line) {
        int i = 0;
        i = skipUntil(line, i, value -> value == ':');

        Set<Integer> winningNumbers = new HashSet<>();

        while (i < line.length() && line.charAt(i) != '|') {
            Utils.Pair<Integer, Integer> result = nextInt(line, i);
            i = result.first;

            winningNumbers.add(result.second);
            i++;
        }

        int match = 0;
        while (i < line.length()) {
            Utils.Pair<Integer, Integer> result = nextInt(line, i);
            i = result.first;

            if (winningNumbers.contains(result.second))
                match++;

            i++;
        }
        return match;
    }

}
