package pie.ilikepiefoo.adventofcode.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileLoaderTest {

    @Test
    public void readFileByLineFromResourceFolder() {
        FileLoader loader = new FileLoader();
        List<String> lines = loader.readFileByLine("testFile.txt");
        assertEquals(5, lines.size());
    }

    @Test
    public void readFileByLineFromTestResourceFolder() {
        FileLoader loader = new FileLoader();
        List<String> lines = loader.readFileByLine("testResource.txt");
        assertEquals(5, lines.size());
    }

}