package test;

import static org.junit.jupiter.api.Assertions.*;
import app.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class WallTest {
    private Wall wall;
    private File file;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        wall = new Wall();
        file = new File("test-notes.txt");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        wall = null;
        file = null;
    }

    @org.junit.jupiter.api.Test
    void saveNotes() {

    }

    @org.junit.jupiter.api.Test
    void loadNotes() {

    }

    @org.junit.jupiter.api.Test
    void readInNotes() {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("Feed the cat!" + "\n");
            fileWriter.write("Feed the dog!" + "\n");

            ArrayList<String> expected = new ArrayList<>();
            expected.add("Feed the cat!");
            expected.add("Feed the dog!");

            assertEquals(expected, wall.readInNotes(file));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) try { fileWriter.close(); } catch (IOException e) {}
        }
    }
}