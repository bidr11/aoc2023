package day05;

import utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static utils.Utils.*;

import static day05.Main.in;
import static day05.Seeds.parseSeeds;

public class Part2 implements Utils.Solver<Long> {
    public Long solve() throws IOException {
        String line = in.readLine();
        List<Pair<Long,Long>> nextStep = parseSeeds(line);

        in.readLine(); // empty line

        while (in.readLine() != null) {
            List<Seeds.SeedMap> maps = new ArrayList<>();

            while ((line = in.readLine()) != null && !line.isEmpty()) {
                maps.add(Seeds.parseMap(line));
                // TODO
            }

        }
        return Utils.findMin(nextStep.stream().map(p -> p.first).toList());
    }
}
