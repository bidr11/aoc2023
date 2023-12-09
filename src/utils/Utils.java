package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public interface Solver<T> {
        T solve() throws IOException;
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
    public static String getFilename(Class<?> clazz) {
        return Paths.get(System.getProperty("user.dir"), "src", clazz.getPackageName(), "input").toString();
    }
    public static int skipUntil(String str, int index, Condition<Character> condition) {
        while (index < str.length() && !condition.test(str.charAt(index))) {
            index++;
        }
        return index;
    }

    public static Pair<Integer,Integer> nextInt(String str, int index) {
        index = skipUntil(str, index, Character::isDigit);

        int number = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            number = number * 10 + (str.charAt(index) - '0');
            index++;
        }
        return new Pair<>(index, number);
    }

    public static Pair<Integer,Long> nextLong(String str, int index) {
        index = skipUntil(str, index, Character::isDigit);

        long number = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            number = number * 10 + (str.charAt(index) - '0');
            index++;
        }
        return new Pair<>(index, number);
    }
    public static Pair<Integer,String> nextWord(String str, int index) {
        index = skipUntil(str, index, Character::isLetter);

        StringBuilder sb = new StringBuilder();
        while (index < str.length() && Character.isLetter(str.charAt(index))) {
            sb.append(str.charAt(index));
            index++;
        }
        return new Pair<>(index, sb.toString());
    }
    public static Pair<Integer,String> nextString(String str, int index) {
        index = skipUntil(str, index, c -> Character.isLetter(c) || Character.isDigit(c));

        StringBuilder sb = new StringBuilder();
        while (index < str.length() && (Character.isLetter(str.charAt(index)) || Character.isDigit(str.charAt(index)))) {
            sb.append(str.charAt(index));
            index++;
        }
        return new Pair<>(index, sb.toString());
    }

    public static String[] readLines(BufferedReader in) throws IOException {
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null)
            if (!line.isEmpty())
                lines.add(line);

        return lines.toArray(new String[0]);
    }
    public static <T extends Comparable<T>> T findMin(Iterable<T> iterable) {
        if (iterable == null) {
            throw new IllegalArgumentException("Iterable cannot be null");
        }

        T min = null;

        for (T element : iterable) {
            if (min == null || element.compareTo(min) < 0) {
                min = element;
            }
        }

        if (min == null) {
            throw new IllegalArgumentException("Iterable cannot be empty");
        }

        return min;
    }
    public static List<Integer> extractNumbers(String line) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < line.length()) {
            i = skipUntil(line, i, Character::isDigit);
            Pair<Integer,Integer> result = nextInt(line, i);
            if (i > 0 && line.charAt(i - 1) == '-') {
                result.second *= -1;
            }
            i = result.first;
            list.add(result.second);
        }
        return list;
    }
    public static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
