package no.ntnu.idatg2001.paths.utility;

import java.io.File;
import no.ntnu.idatg2001.paths.base.Link;
import no.ntnu.idatg2001.paths.base.Passage;
import no.ntnu.idatg2001.paths.base.Story;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FileHandlerTest {

  Story story;

  /*public static void main(String[] args) {
    String filename = "paths/src/test/resources/FileHandlerTestDocument.paths";


    try {
      Story story = FileHandler.readStory(filename);
      assert story.getTitle().equals("Haunted House");
      assert story.getPassages().size() == 3;
      System.out.println("Story title: " + story.getTitle());
      System.out.println("Number of passages: " + story.getPassages().size());

      // Skriv ut tittel og innhold for hver passasje
      for (Passage passage : story.getPassages()) {
        System.out.println("\nPassage title: " + passage.getTitle());
        System.out.println("Passage content: " + passage.getContent());

        System.out.println("Links in passage: " + passage.getLinks().size() + "\n");
        // Skriv ut tittel og målpassasje for hver link i passasjen
        for (Link link : passage.getLinks()) {
          System.out.println("Link title: " + link.getReference());
          System.out.println("Link target passage: " + link.getText());
          // }
        }
        System.out.println("--------------------");
      }
      //System.out.println("all the passages: " + story.getPassages());
    } catch (IOException e) {
      System.out.println("An error occurred while reading the story: " + e.getMessage());
    }
  }*/


  @BeforeEach
  public void createStory() {
    File file = new File("src/test/resources/FileHandlerTestDocument.paths");
    String filename = file.getAbsolutePath();
    try {
      story = FileHandler.initializeStory(filename);
    } catch (IOException e) {
      System.out.println("An error occurred while reading the story: " + e.getMessage());
    }
  }

  @Test
  void testTitle() {
    assertEquals("Haunted House", story.getTitle());
  }

  @Test
  void testPassagesSize() {
    assertEquals(3, story.getPassages().size());
  }

  @Test
  void testPassage1() {
    Passage testPassage1 = new Passage("The book of spells",
        "You open the book and see a list of spells. You read one aloud.");
    testPassage1.addLink(new Link("Go back", "Another room"));
    assertTrue(story.getPassages().contains(testPassage1));
    }

  @Test
  void  testPassage2() {
    Passage testPassage2 = new Passage("Another room",
        "The door opens to another room. You see a desk with a large, dusty book.");
    testPassage2.addLink(new Link("Open the book", "The book of spells"));
    testPassage2.addLink(new Link("Go back", "Beginnings"));
    assertTrue(story.getPassages().contains(testPassage2));
  }

  @Test
  void testOpeningPassage() {
    Passage testOpeningPassage = new Passage("Beginnings",
        "You are in a small, dimly lit room. There is a door in front of you.");
    testOpeningPassage.addLink(new Link("Try to open the door", "Another room"));
    assertEquals(story.getOpeningPassage(), testOpeningPassage);
  }
}

