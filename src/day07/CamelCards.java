package day07;

import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CamelCards {
    public interface CardMatcher {
        int[] getMatchingCards(int[] cardCounts);
    }
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

        assert handType != -1;

        return handType;
    }
    public static long handStrength(String line, Map<Character,Integer> cardValues, CardMatcher cardMatcher) {
        int[] cardCounts = new int[13];
        int strength = 0;
        int handType;

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ') {
            cardCounts[cardValues.get(line.charAt(i)) - 1]++;
            strength = strength * 13 + cardValues.get(line.charAt(i));
            i++;
        }

        int[] matchingCards = cardMatcher.getMatchingCards(cardCounts);
        handType = getHandType(matchingCards);

        return ((long) handType * 13 * 13 * 13 * 13 * 13 * 13 * 13) + strength;
    }
    public static int solve(BufferedReader in, Map<Character,Integer> cardValues, CardMatcher cardMatcher) throws IOException {
        List<Utils.Pair<Long,Integer>> hands = new ArrayList<>();
        int ans = 0;

        String line;
        while ((line = in.readLine()) != null) {
            long hand = handStrength(line, cardValues, cardMatcher);
            int bet = Utils.nextInt(line, 5).second;
            hands.add(new Utils.Pair<>(hand, bet));
        }
        hands.sort(Comparator.comparingLong(a -> a.first));

        for (int rank = 0; rank < hands.size(); rank++) {
            int bet = hands.get(rank).second;
            ans += bet * (rank + 1);
        }

        return ans;
    }
}

