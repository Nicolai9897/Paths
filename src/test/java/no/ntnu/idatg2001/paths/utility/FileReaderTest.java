package no.ntnu.idatg2001.paths.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import no.ntnu.idatg2001.paths.Actions.Action;
import no.ntnu.idatg2001.paths.Actions.GoldAction;
import no.ntnu.idatg2001.paths.Actions.HealthAction;
import no.ntnu.idatg2001.paths.Actions.InventoryAction;
import no.ntnu.idatg2001.paths.Actions.ScoreAction;
import no.ntnu.idatg2001.paths.base.Link;
import no.ntnu.idatg2001.paths.base.Passage;
import no.ntnu.idatg2001.paths.base.Story;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the FileHandler class
 */
public class FileReaderTest {

  Story story;


    /**
     * Initializes the test story from the test document before each test
     */
  @BeforeEach
  public void createStory() {
    File file = new File("src/test/resources/FileHandlerTestDocument.paths");
    String filename = file.getAbsolutePath();
    try {
      story = FileReader.initializeStory(filename);
    } catch (IOException e) {
      System.out.println("An error occurred while reading the story: " + e.getMessage());
    }
  }

  /**
   * Tests that the story is initialized with the correct title
   */
  @Test
  void testTitle() {
    assertEquals("Haunted House", story.getTitle());
  }

  /**
   * Tests that the story is initialized with the correct description
   */
  @Test
  void testPassagesSize() {
    assertEquals(5, story.getPassages().size());
  }

  /**
   * Test that the story has added the book of spells passage correctly
   */
  @Test
  void testgetTheBookOfSpells() {
    Passage testPassage = new Passage("The book of spells",
        "You open the book and see a list of spells. You read one aloud.");
    Link testLink1 = new Link("Go back", "Another room");
    Link testLink2 = new Link("Go to next room", "The next room");
    List<Action> testActions = new ArrayList<>();
    //testActions.add(new HealthAction(-10));
    testActions.add(new InventoryAction("sword"));

    testLink2.addAction(testActions);

    testPassage.addLink(testLink1);
    testPassage.addLink(testLink2);
    assertTrue(story.getPassages().contains(testPassage));
    }

  /**
   * Test that the story has added the another room passage correctly
   */
  @Test
  void testGetAnotherRoom() {
    Passage testPassage = new Passage("Another room",
        "The door opens to another room. You see a desk with a large, dusty book.");
    testPassage.addLink(new Link("Open the book", "The book of spells"));
    testPassage.addLink(new Link("Go back", "Beginnings"));
    assertTrue(story.getPassages().contains(testPassage));
  }

  /**
   * Test that the story has added the next room passage correctly
   */
  @Test
  void testGetTheNextRoom() {
    Passage testPassage = new Passage("The next room",
        "You have entered the next room to great discomfort. You have lost 10 " +
            "healthpoints, but you found a sword.");
    Link testLink1 = new Link("Go to the other next room", "The other next room");
    Link testLink2 = new Link("Go back", "The book of spells");


    List<Action> testActions = new ArrayList<>();
    testActions.add(new ScoreAction(50));
    testActions.add(new GoldAction(30));

    testLink1.addAction(testActions);

    testPassage.addLink(testLink1);
    testPassage.addLink(testLink2);

    assertTrue(story.getPassages().contains(testPassage));
  }

  /**
   * Test that the story has added the other next room passage correctly
   */
  @Test
  void testGetTheOtherNextRoom() {
    Passage testPassage = new Passage("The other next room",
        "You have entered the other next room. You have gained 50 points and 30 gold.");
    Link testLink = new Link("Go back", "The next room");

    testPassage.addLink(testLink);
    assertTrue(story.getPassages().contains(testPassage));
  }

  /**
   * Test that the story has added the beginnings passage correctly
   */
  @Test
  void testGetBeginnings() {
    Passage testPassage = new Passage("Beginnings",
        "You are in a small, dimly lit room. There is a door in front of you.");
    testPassage.addLink(new Link("Try to open the door", "Another room"));
    assertTrue(story.getPassages().contains(testPassage));
  }


  /**
   * Test that the story has added the correct passage as opening passage
   */
  @Test
  void testOpeningPassage() {
    Passage testOpeningPassage = new Passage("Beginnings",
        "You are in a small, dimly lit room. There is a door in front of you.");
    testOpeningPassage.addLink(new Link("Try to open the door", "Another room"));
    assertEquals(story.getOpeningPassage(), testOpeningPassage);
  }



}

