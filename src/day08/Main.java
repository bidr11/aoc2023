package day08;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static BufferedReader in;
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        solve(new Part1());
        solve(new Part2());

        System.out.println("Total time: " + (System.nanoTime() * 1.0 - startTime * 1.0) / 1_000_000 + "ms");
    }

    public static <T extends Number> void solve(Utils.Solver<T> solver) throws IOException {
        String filename = Utils.getFilename(Main.class);
        in = new BufferedReader(new FileReader(filename));
        T ans = solver.solve(in);
        System.out.println(ans);
    }
}
