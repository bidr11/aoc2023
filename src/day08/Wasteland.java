package day08;

import utils.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static day08.Main.in;

public class Wasteland {
    public static Map<String, Utils.Pair<String,String>> getMap() throws IOException {
        Map<String,Utils.Pair<String,String>> map = new HashMap<>();
        String line;
        while ((line = in.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }
            int i = 0;
            Utils.Pair<Integer,String> pair;
            pair = Utils.nextString(line, i);
            i = pair.first;
            String key = pair.second;

            pair = Utils.nextString(line, i);
            i = pair.first;
            String left = pair.second;

            pair = Utils.nextString(line, i);
            String right = pair.second;

            map.put(key, new Utils.Pair<>(left, right));
        }

        return map;
    }
}
