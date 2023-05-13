package no.ntnu.idatg2001.paths.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    Path path = Paths.get(filename);
    Story story = null;
    String title = "";

    try (Scanner scanner = new Scanner(path)) {
      if (scanner.hasNextLine()) {
        title = scanner.nextLine().trim();
      }

      // Read the file line by line
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
          continue;
        }

        // If the line is a passage, go into the if statement, and read the passage and its links
        if (line.startsWith("::")) { // If the line is a passage,
          String passageTitle = line.substring(2).trim();
          StringBuilder contentBuilder = new StringBuilder();
          List<Link> links = new ArrayList<>();

          // Read the passage and its links
          while (scanner.hasNextLine()) {
            line = scanner.nextLine().trim();
            if (line.isEmpty()) {
              break;
            }

            if (line.startsWith("[")) { // If the line is a link, add it to the list of links
              // The link title is the text between the brackets
              String linkTitle = line.substring(1, line.indexOf("]"));
              // The link passage is the text between the parentheses
              String linkPassage = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
              // Add the link to the list of links for the passage
              links.add(new Link(linkTitle, linkPassage));
            } else {
              contentBuilder.append(line);
            }
          }

          // If the story already exists, add the passage to it before finding the next passage
          Passage passage = new Passage(passageTitle, contentBuilder.toString());
          if (story == null) {
            story = new Story(title, passage);
          }
          for (Link link : links) {
            passage.addLink(link);
          }
          story.addPassage(passage);
        }
      }
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
    return story;
  }




  /**
   * Writes a story to a file.
   *
   * @param story
   * @param filename
   * @throws IOException
   */
  public static void writeStory(Story story, String filename) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
      writer.println(story.getTitle() + "\n");
      writer.println(story.getOpeningPassage().getTitle());
      writer.println(story.getOpeningPassage().getContent());

      for (Link link : story.getOpeningPassage().getLinks()) {
        writer.println("[" + link.getText() + "](" + link.getReference() + ")");
      }
      writer.println();

      for (Passage passage : story.getPassages()) {
        writer.println(":: " + passage.getTitle());
        writer.println(passage.getContent());

        for (Link link : passage.getLinks()) {
          writer.println("[" + link.getText() + "](" + link.getReference() + ")");
        }
        writer.println();
      }
    }
  }
}
