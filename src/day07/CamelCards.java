package day07;

import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class CamelCards {
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
    private static int getHandType(int[] matchingCards) {
        int handType = -1;

        if (matchingCards[4] == 1)
            handType = 6; // Five of a kind
        else if (matchingCards[3] == 1)
            handType = 5; // Four of a kind
        else if (matchingCards[2] == 1 && matchingCards[1] == 1)
            handType = 4; // Three of a kind and a pair (Full house)
        else if (matchingCards[2] == 1)
            handType = 3; // Three of a kind
        else if (matchingCards[1] == 2)
            handType = 2; // Two pair
        else if (matchingCards[1] == 1)
            handType = 1; // One pair
        else if (matchingCards[0] == 5)
            handType = 0; // High card

        return handType;
    }
    public static long handStrength(String line) {
        int[] cardCounts = new int[13];
        int strength = 0;
        int handType;

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ') {
            cardCounts[cardValues.get(line.charAt(i)) - 1]++;
            strength = strength * 13 + cardValues.get(line.charAt(i));
            i++;
        }

        int[] matchingCards = new int[5];
        for (int count: cardCounts) {
            if (count > 0)
                matchingCards[count - 1]++;
        }
        handType = getHandType(matchingCards);

        return ((long) handType * 13 * 13 * 13 * 13 * 13) + strength;
    }

    public static Utils.Pair<Long,Integer> handAndBet(String line) {
        long hand = handStrength(line);
        int bet = Utils.nextInt(line, 5).second;

        return new Utils.Pair<>(hand, bet);
    }
}

