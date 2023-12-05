package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public interface Solver {
        <T> T solve() throws IOException;
    }
    public interface Condition<T> {
        boolean test(T value);
    }

    public static class Pair<T,M> {
        public T first;
        public M second;

        public Pair(T first, M second) {
            this.first = first;
            this.second = second;
        }

        public Pair() { }
    }

    public static int skipUntil(String str, int index, Condition<Character> condition) {
        while (index < str.length() && !condition.test(str.charAt(index))) {
            index++;
        }
        return index;
    }

    public static Pair<Integer,Integer> nextInt(String str, int index) {
        int number = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            number = number * 10 + (str.charAt(index) - '0');
            index++;
        }
        return new Pair<>(index, number);
    }

    public static Pair<Integer,Long> nextLong(String str, int index) {
        long number = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            number = number * 10 + (str.charAt(index) - '0');
            index++;
        }
        return new Pair<>(index, number);
    }

    public static String[] readLines(BufferedReader in) throws IOException {
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null)
            lines.add(line);

        return lines.toArray(new String[0]);
    }
//    public static <T extends Comparable<T>> T findMin(Iterable<T> iterable) {
//        if (iterable == null) {
//            throw new IllegalArgumentException("Iterable cannot be null");
//        }
//
//        T min = iterable.;
//
//        for (T element : iterable) {
//            if (min == null || element.compareTo(min) < 0) {
//                min = element;
//            }
//        }
//
//        if (min == null) {
//            throw new IllegalArgumentException("Iterable cannot be empty");
//        }
//
//        return min;
//    }
}
