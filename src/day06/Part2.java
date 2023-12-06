package day06;

import utils.Utils;

import java.io.IOException;

import static day06.Main.in;
import static day06.WaitForIt.*;

public class Part2 implements Utils.Solver<Long>{
    public Long solve() throws IOException {
        long time = getNumber(in.readLine());
        long distance = getNumber(in.readLine());

        return getWinnings(time, distance);
    }
}
