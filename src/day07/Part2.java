package day07;

import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Part2 implements Utils.Solver<Integer> {
    private static final Map<Character,Integer> cardValues = new HashMap<>() {{
        this.put('J', 1);
        this.put('2', 2);
        this.put('3', 3);
        this.put('4', 4);
        this.put('5', 5);
        this.put('6', 6);
        this.put('7', 7);
        this.put('8', 8);
        this.put('9', 9);
        this.put('T', 10);
        this.put('Q', 11);
        this.put('K', 12);
        this.put('A', 13);
    }};
    int[] getMatchingCards(int[] cardCounts) {
        int[] matchingCards = new int[5];
        int jokerCount = cardCounts[0];

        if (jokerCount == 5) {
            matchingCards[matchingCards.length - 1] = 1;
            return matchingCards;
        }

        for (int i = cardCounts.length - 1; i >= 1; i--) {
            int count = cardCounts[i];
            if (count > 0)
                matchingCards[count - 1]++;
        }

        int i = matchingCards.length - 1;
        while (i >= 0 && matchingCards[i] == 0)
            i--;

        matchingCards[i + jokerCount]++;
        matchingCards[i]--;

        return matchingCards;
    }
    public Integer solve(BufferedReader in) throws IOException {
        return CamelCards.solve(in, cardValues, this::getMatchingCards);
    }
}
