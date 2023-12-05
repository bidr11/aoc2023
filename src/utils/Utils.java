package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
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

    public static String[] readLines(BufferedReader in) throws IOException {
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null)
            lines.add(line);

        return lines.toArray(new String[0]);
    }

//    public static void main(String[] args) {
//        String inputString = "sldijf 342 df";
//        int index = 0, number = 0;
//
//        index = skipUntil(inputString, index, value -> Character.isDigit(value));
//        System.out.println("Updated index: " + index);
//        // Example of using the nextInt method
//
//        Pair<Integer,Integer> result = nextInt(inputString, index);
//        index = result.first;
//        number = result.second;
//
//        // Continue with the updated index or perform other actions
//        System.out.println("Parsed integer: " + number);
//        System.out.println("Updated index: " + index);
//    }
}
