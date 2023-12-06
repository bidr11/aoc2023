package day06;

import utils.Utils;

public class WaitForIt {
//    public static long getWinnings(long time, long distance) {
//        long speed = 1;
//        long ans = 0;
//
//        while (speed * (time - speed) <= distance) {
//            speed++;
//        }
//        long s = speed;
//
//        while (speed * (time - speed) > distance) {
//            speed++;
//            ans++;
//        }
//
//        return ans;
//    }

    public static long getWinnings(long time, long distance) {
        long delta = time * time - 4 * distance;
        long start = (long) (-1 * (- time + Math.sqrt(delta)) / 2);
        long end = (long) (-1 * (- time - Math.sqrt(delta)) / 2);
        return end - start;
    }

    public static long getNumber(String line) {
        int i = 0;
        long num = 0;
        Utils.skipUntil(line, i, Character::isDigit);

        while (i < line.length()) {
            if (!Character.isDigit(line.charAt(i))) {
                i++;
                continue;
            }

            while (i < line.length() && Character.isDigit(line.charAt(i))) {
                num = num * 10 + line.charAt(i) - '0';
                i++;
            }
        }
        return num;
    }
}
