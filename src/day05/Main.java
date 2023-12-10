package day05;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static BufferedReader in;
    public static void main(String[] args) throws IOException {
        solve(new Part1());
        solve(new Part2());
    }

    public static void solve(Utils.Solver<Long> solver) throws IOException {
        String filename = Utils.getFilename(Main.class);
        in = new BufferedReader(new FileReader(filename));
        long ans = solver.solve(in);
        System.out.println(ans);
    }
}
