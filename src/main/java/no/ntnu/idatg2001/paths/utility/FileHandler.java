package no.ntnu.idatg2001.paths.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    Story story = null;
    String title = "";
    List passages = new ArrayList();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      title = reader.readLine().trim();


      String line = reader.readLine();
      while (line != null) {
        line.trim();
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
            story.addPassage(new Passage(passageTitle, contentBuilder.toString()));
          } else { // If the story does not exist, make the story
            story = new Story(title, new Passage(passageTitle, contentBuilder.toString()));
          }
        }

      }
    }
    return story;
  }
}


