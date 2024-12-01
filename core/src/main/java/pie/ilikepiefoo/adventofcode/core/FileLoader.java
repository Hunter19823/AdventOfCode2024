package pie.ilikepiefoo.adventofcode.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FileLoader {

    private InputStream readFileFromResources(String fileName) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (stream != null) {
            return stream;
        }
        stream = getClass().getClassLoader().getResourceAsStream("./"+fileName);
        if (stream != null) {
            return stream;
        }
        stream = getClass().getClassLoader().getResourceAsStream("."+fileName);
        if (stream != null) {
            return stream;
        }
        throw new IllegalArgumentException("Cannot find resource by the name of: "+fileName);
    }

    public List<String> readFileByLine(String fileName) {
        InputStream inputStream = readFileFromResources(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
