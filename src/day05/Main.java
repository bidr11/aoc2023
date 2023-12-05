package day05;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static day05.Seeds.filename;

public class Main {
    static BufferedReader in;
    public static void main(String[] args) throws IOException {
        solve(new Part1());
//        solve(new Part2());
    }

    public static void solve(Utils.Solver solver) throws IOException {
        in = new BufferedReader(new FileReader(filename));
        long ans = solver.solve();
        System.out.println(ans);
    }
}
