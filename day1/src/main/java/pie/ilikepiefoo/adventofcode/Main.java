package pie.ilikepiefoo.adventofcode;

import pie.ilikepiefoo.adventofcode.core.FileLoader;
import pie.ilikepiefoo.adventofcode.core.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main( String[] args ) {
        FileLoader reader = new FileLoader();
        List<String> testData = reader.readFileByLine("input.txt");
        List<Pair<Integer, Integer>> pairs = testData.stream().map(Main::parseNumberPair).toList();
        Map<Integer, Integer> occuranceMap = new HashMap<>();
        pairs.stream().map(Pair::right).forEach((i) -> {
            if(occuranceMap.containsKey(i)) {
                occuranceMap.put(i, occuranceMap.get(i)+1);
            }else {
                occuranceMap.put(i, 1);
            }
        });
        List<Integer> leftList = pairs.stream().map(Pair::left).sorted().toList();
        List<Integer> similarityScores = new ArrayList<>(leftList.size());
        long totalSum = 0;
        for (int i=0; i<leftList.size(); i++) {
            similarityScores.add(getSimilarityScore(leftList.get(i), occuranceMap));
            totalSum += similarityScores.getLast();
        }
        System.out.println("Totals: " + similarityScores);
        System.out.println("Total Sum: "+ totalSum);
        // Calculate a total similarity score by
        // adding up each number in the left list
        // after multiplying it by
        // the number of times that number appears in the right list.
    }

    public static Integer getSimilarityScore(Integer input, Map<Integer, Integer> occuranceMap) {
        return input * occuranceMap.getOrDefault(input, 0);
    }

    public static Pair<Integer, Integer> parseNumberPair(String line) {
        String[] parts = line.split("\\s+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Cannot parse broken line: "+ line);
        }
        return new Pair<>(Integer.parseInt(parts[ 0 ]), Integer.parseInt(parts[ 1 ]));
    }


}
