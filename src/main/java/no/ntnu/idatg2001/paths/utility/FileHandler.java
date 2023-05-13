package no.ntnu.idatg2001.paths.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.ntnu.idatg2001.paths.Link;
import no.ntnu.idatg2001.paths.Passage;
import no.ntnu.idatg2001.paths.Story;

public class FileHandler {


  /**
   * Reads a story from a file and returns a story object.
   *
   * @param filename of the file to read from
   * @return The final story object
   * @throws IOException if the file is not found
   */
  public static Story readStory(String filename) throws IOException {
    Path path = Path.of(filename);
    Story story = null;
    String title = "";

    try (BufferedReader reader = Files.newBufferedReader(path)) {
      title = reader.readLine().trim();


      // Read the file line by line
       String line;
      while ((line = reader.readLine()) != null) {
        line = line.trim();
        if (line.isEmpty()) {
          continue;
        }

        // If the line is a passage, go into the if statment, and read the passage and its links
        if (line.startsWith("::")) { // If the line is a passage,
          String passageTitle = line.substring(2).trim();
          StringBuilder contentBuilder = new StringBuilder();
          List<Link> links = new ArrayList<>();

          // Read the passage and its links
          while ((line = reader.readLine()) != null && !line.isEmpty()) {
            line = line.trim();
            if (line.startsWith("[")) { // If the line is a link, add it to the list of links
              // The link title is the text between the brackets
              String linkTitle = line.substring(1, line.indexOf("]"));
              // The link passage is the text between the parentheses
              String linkPassage = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
              // Add the link to the list of links TODO: rework this, or make sure it is correct.
              links.add(new Link(linkTitle, linkPassage));
            } else {
              contentBuilder.append(line);
            }
          }

          // If the story already exists, add the passage to it, before finding the next passage
          if (story != null) {
            Passage passage = new Passage(passageTitle, contentBuilder.toString());
            for (Link link : links) {
              passage.addLink(link);
            }
            story.addPassage(passage);
          } else { // If the story does not exist, create the story and opening passage
            Passage openingPassage = new Passage(passageTitle, contentBuilder.toString());
            for (Link link : links) {
              openingPassage.addLink(link);
            }
            story = new Story(title, openingPassage);
          }
        }
      }
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
    return story;
  }
}


