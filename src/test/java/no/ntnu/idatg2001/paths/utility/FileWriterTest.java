package no.ntnu.idatg2001.paths.utility;

import no.ntnu.idatg2001.paths.base.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileWriterTest {
    Story story;

    @BeforeEach
    void createStory() {
        File file = new File("src/test/resources/FileHandlerTestDocument.paths");
        String filename = file.getAbsolutePath();
        try {
            story = FileReader.initializeStory(filename);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the story: " + e.getMessage());
        }
    }

    @Test
    void testWriteStory() {
        String filename = "src/test/resources/qwerFileWriterTestDocument.paths";
        try {
            FileWriter.writeStory(story, filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the story: " + e.getMessage());
        }
    }



}
