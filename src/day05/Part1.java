package day05;

import utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static day05.Main.in;

public class Part1 implements Utils.Solver<Long> {

    public Long solve() throws IOException {
        String line = in.readLine();
        List<Long> nextStep = Seeds.parseSeeds(line);

        in.readLine(); // empty line

        while (in.readLine() != null) {
            List<Seeds.SeedMap> maps = new ArrayList<>();

            while ((line = in.readLine()) != null && !line.isEmpty()) {
                maps.add(Seeds.parseMap(line));
            }

            nextStep.replaceAll(src -> Seeds.getDestination(src, maps));
        }

        return Utils.findMin(nextStep);
    }
}
