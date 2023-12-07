package day07;

import utils.Utils;

import java.io.IOException;
import java.util.*;

public class Part1 implements Utils.Solver<Integer>{
    private static final Map<Character,Integer> cardValues = new HashMap<>() {{
        this.put('2', 1);
        this.put('3', 2);
        this.put('4', 3);
        this.put('5', 4);
        this.put('6', 5);
        this.put('7', 6);
        this.put('8', 7);
        this.put('9', 8);
        this.put('T', 9);
        this.put('J', 10);
        this.put('Q', 11);
        this.put('K', 12);
        this.put('A', 13);
    }};
    int[] getMatchingCards(int[] cardCounts) {
        int[] matchingCards = new int[5];
        for (int count: cardCounts) {
            if (count > 0)
                matchingCards[count - 1]++;
        }
        return matchingCards;
    }
    public Integer solve() throws IOException {
        return CamelCards.solve(cardValues, this::getMatchingCards);
    }
}
