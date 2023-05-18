package no.ntnu.idatg2001.paths.utility;


import static no.ntnu.idatg2001.paths.utility.ActionTypeEnums.GOLD;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import no.ntnu.idatg2001.paths.Actions.Action;
import no.ntnu.idatg2001.paths.Actions.GoldAction;
import no.ntnu.idatg2001.paths.Actions.HealthAction;
import no.ntnu.idatg2001.paths.Actions.InventoryAction;
import no.ntnu.idatg2001.paths.Actions.ScoreAction;
import no.ntnu.idatg2001.paths.base.Link;
import no.ntnu.idatg2001.paths.base.Passage;
import no.ntnu.idatg2001.paths.base.Story;

public class FileHandler {


  /**
   * Reads a story from a file and returns a story object.
   *
   * @param filename of the file to read from
   * @return The final story object
   * @throws IOException if the file is not found
   */
  /*public static Story readStory(String filename) throws IOException {
    Story story = null;
    String title = "";

    try (Scanner scanner = new Scanner(Paths.get(filename))) {
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
  }*/


  /**
   * Initializes and constructs a Story object based on the content of a file.
   *
   * @param filename the name of the file to read from
   * @return the constructed Story object
   * @throws IOException if the file is not found
   */
  public static Story initializeStory(String filename) throws IOException {
    String title = readTitle(filename);
    List<Passage> passages = readPassages(filename);
    Story story = new Story(title, passages.get(0));
    for (int i = 1; i < passages.size(); i++) {
      story.addPassage(passages.get(i));
    }
    return story;
  }

  /**
   * Reads the title of the story from the file.
   *
   * @param filename the name of the file to read from
   * @return the title of the story
   * @throws IOException if the file is not found
   */
  private static String readTitle(String filename) throws IOException {
    String title = "";
    try (Scanner scanner = new Scanner(Paths.get(filename))) {
      if (scanner.hasNextLine()) {
        title = scanner.nextLine().trim();
      }
    } catch (IOException e) {
      System.out.println("Unable to find: " + e.getMessage());
    }
    return title;
  }


  /**
   * Scans through the document to look for the "::" indication start of chapter. When found,
   * it goes into the readPassage method to read the passage.
   * @param filename The name of the file to read from
   * @return A list of passages
   * @throws IOException if the file is not found
   */
  private static List<Passage> readPassages(String filename) throws IOException {
    List<Passage> passages = new ArrayList<>();
    try (Scanner scanner = new Scanner(Paths.get(filename))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
          continue;
        }
        // If the line is a passage, go into the readPassage method
        if (line.startsWith("::")) {
          Passage passage = readPassage(scanner, line);
          passages.add(passage);
        }
      }
    } catch (IOException e) {
      System.out.println("Unable to find: " + e.getMessage());
    }
    return passages;
  }

  /**
   * Extracts the passage title, content and scans for potential links in the passage.
   * @param scanner The scanner used to read the file
   * @param line The line to read from
   * @return The passage
   */
  private static Passage readPassage(Scanner scanner, String line) {
    String passageTitle = line.substring(2).trim();
    StringBuilder contentBuilder = new StringBuilder();
    List<Link> links = new ArrayList<>();
    while (scanner.hasNextLine()) {
      line = scanner.nextLine().trim();
      if (line.isEmpty()) {
        break;
      }
      if (line.startsWith("[")) {
        Link link = readLink(line);
        links.add(link);
      } else if (line.startsWith("{")) {
        List<Action> actions = new ArrayList<>();
        boolean nextLineIsAction = true;
        while (nextLineIsAction) {
          Action action = readAction(line);
          actions.add(action);
          if (!scanner.nextLine().trim().equals("}")) {
            nextLineIsAction = false;
          } else {
            line = scanner.nextLine().trim();
          }
        }
        links.get(links.size() - 1).addAction(actions);
      }else {
        contentBuilder.append(line);
      }
    }
    Passage passage = new Passage(passageTitle, contentBuilder.toString());
    for (Link link : links) {
      passage.addLink(link);
    }
    return passage;
  }

  /**
   * Reads the text and reference that make up the link.
   * @param line The line to read from
   * @return The link
   */
  private static Link readLink(String line) {
    String linkTitle = line.substring(1, line.indexOf("]"));
    String linkPassage = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
    return new Link(linkTitle, linkPassage);
  }

  private static Action readAction(String line) {
    String actionType = line.substring(1, line.indexOf("}"));
    String actionValue = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
    ActionTypeEnums actionTypeEnum = ActionTypeEnums.valueOf(actionType.toUpperCase());

    return switch (actionTypeEnum) {
      case GOLD -> new GoldAction(Integer.parseInt(actionValue));
      case HEALTH -> new HealthAction(Integer.parseInt(actionValue));
      case SCORE -> new ScoreAction(Integer.parseInt(actionValue));
      case INVENTORY -> new InventoryAction(actionValue);
      default -> null;
    };
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
