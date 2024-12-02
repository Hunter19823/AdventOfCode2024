package pie.ilikepiefoo.adventofcode;

import pie.ilikepiefoo.adventofcode.core.FileLoader;
import pie.ilikepiefoo.adventofcode.core.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main( String[] args ) {
        FileLoader reader = new FileLoader();
        List<String> testData = reader.readFileByLine("input.txt");
        List<Pair<Integer, Integer>> pairs = testData.stream().map(Main::parseNumberPair).toList();
        List<Integer> leftList = pairs.stream().map(Pair::left).sorted().toList();
        List<Integer> rightList = pairs.stream().map(Pair::right).sorted().toList();
        List<Integer> distances = new ArrayList<>(leftList.size());
        long totalSum = 0;
        for (int i=0; i<leftList.size(); i++) {
            distances.add(Math.abs(leftList.get(i) - rightList.get(i)));
            totalSum += distances.getLast();
        }
        System.out.println("Totals: " + distances);
        System.out.println("Total Sum: "+ totalSum);
    }

    public static Pair<Integer, Integer> parseNumberPair(String line) {
        String[] parts = line.split("\\s+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Cannot parse broken line: "+ line);
        }
        return new Pair<>(Integer.parseInt(parts[ 0 ]), Integer.parseInt(parts[ 1 ]));
    }


}
