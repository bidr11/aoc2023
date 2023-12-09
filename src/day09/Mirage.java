package day09;

import java.util.ArrayList;
import java.util.List;

public class Mirage {
    public static long extrapolateForward(List<Integer> sequence) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < sequence.size() - 1; i++) {
            ans.add(sequence.get(i + 1) - sequence.get(i));
        }

        int size = ans.size();
        if (size == 1 || ans.stream().allMatch(x -> x == 0)) {
            return ans.get(size - 1);
        }
        return extrapolateForward(ans) + ans.get(size - 1);
    }

    public static long extrapolateBackward(List<Integer> sequence) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < sequence.size() - 1; i++) {
            ans.add(sequence.get(i + 1) - sequence.get(i));
        }

        int size = ans.size();
        if (size == 1 || ans.stream().allMatch(x -> x == 0)) {
            return ans.get(0);
        }
        return ans.get(0) - extrapolateBackward(ans);
    }
}
