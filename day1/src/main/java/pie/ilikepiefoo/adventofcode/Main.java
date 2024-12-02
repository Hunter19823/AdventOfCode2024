package pie.ilikepiefoo.adventofcode;

import pie.ilikepiefoo.adventofcode.core.FileLoader;

import java.util.List;

public class Main {
    public static void main( String[] args ) {
        FileLoader reader = new FileLoader();
        List<String> testData = reader.readFileByLine("testFile.txt");
    }
}
