package day05;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.*;


public class Seeds {
    public static class SeedMap {
        long dest_start, src_start, range_len;

        public SeedMap(long dest_start, long src_start, long range_len) {
            this.dest_start = dest_start;
            this.src_start = src_start;
            this.range_len = range_len;
        }
        public SeedMap() {}
    }
    public static List<Pair<Long,Long>> parseSeeds(String line) {
        List<Pair<Long,Long>> list = new ArrayList<>();

        int i = 0;
        while (i < line.length()) {
            Pair<Integer,Long> startResult = nextLong(line, i);
            Pair<Integer,Long> rangeResult = nextLong(line, startResult.first);

            long start = startResult.second;
            long range = rangeResult.second;

            i = rangeResult.first;
            list.add(new Pair<>(start, start + range - 1));
        }

        return list;
    }
    public static SeedMap parseMap(String line) {
        List<Long> list = extractNumbers(line);
        return new SeedMap(list.get(0), list.get(1), list.get(2));
    }
    public static long getDestination(long src, List<SeedMap> maps) {
        for (SeedMap map : maps) {
            if (src >= map.src_start && src < map.src_start + map.range_len) {
                return map.dest_start + src - map.src_start;
            }
        }
        return src;
    }
    public static List<Long> extractNumbers(String line) {
        List<Long> list = new ArrayList<>();
        int i = 0;
        while (i < line.length()) {
            Pair<Integer,Long> result = nextLong(line, i);
            i = result.first;
            list.add(result.second);
        }
        return list;
    }
}
