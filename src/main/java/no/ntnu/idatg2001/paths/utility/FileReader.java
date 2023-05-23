package no.ntnu.idatg2001.paths.utility;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import no.ntnu.idatg2001.paths.actions.Action;
import no.ntnu.idatg2001.paths.actions.GoldAction;
import no.ntnu.idatg2001.paths.actions.HealthAction;
import no.ntnu.idatg2001.paths.actions.InventoryAction;
import no.ntnu.idatg2001.paths.actions.ScoreAction;
import no.ntnu.idatg2001.paths.base.Link;
import no.ntnu.idatg2001.paths.base.Passage;
import no.ntnu.idatg2001.paths.base.Story;

public class FileReader {

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

        boolean hasNextLine = true;
        while (hasNextLine && line.startsWith("{")) {
          Action action = readAction(line);
          actions.add(action);

            if (!scanner.hasNextLine()) {
              line = scanner.nextLine().trim();
            } else {
              hasNextLine = false;
            }

          }
        links.get(links.size() - 1).addAction(actions);
      } else {
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

  /**
   * Reads the action type and value of the action.
   * @param line The line to read from
   * @return The action
   */
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



}
