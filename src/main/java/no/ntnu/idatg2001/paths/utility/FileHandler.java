package no.ntnu.idatg2001.paths.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    String title;
    Passage newPassage;

    try (Scanner scanner = new Scanner(new File(filename))) {
      title = scanner.nextLine().trim();

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();

        // Check for passage start
        if (line.startsWith("::")) {
          String passageTitle = line.substring(2).trim();
          StringBuilder contentBuilder = new StringBuilder();
          List<Link> links = new ArrayList<>();

          while (scanner.hasNextLine() && !(line = scanner.nextLine().trim()).isEmpty()) {
            if (line.startsWith("[")) {
              String linkTitle = line.substring(1, line.indexOf("]"));
              String linkPassage = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
              links.add(new Link(linkTitle, linkPassage));
            } else {
              contentBuilder.append(line);
            }
          }
          newPassage = new Passage(passageTitle, contentBuilder.toString());
          for (Link link : links) {
            newPassage.addLink(link);
          }

          if (story != null) {
            story.addPassage(newPassage);
          } else {
            story = new Story(title, newPassage);
          }
        }
      }
    }
    return story;
  }
}


