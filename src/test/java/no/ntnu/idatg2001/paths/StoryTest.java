package no.ntnu.idatg2001.paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoryTest {

  Story story;
  Passage testPassage1;
  Link testLink1;


  @BeforeEach
  public void setUp() {
    testPassage1 = new Passage("First passage", "You are currently in the first passage");
    testLink1 = new Link("Go to forest", "Forrest");
    testPassage1.addLink(testLink1);

    story = new Story("Test story", testPassage1);
  }


  @Test
  void testStoryInitialization() {
    assertEquals("Test story", story.getTitle());
    assertEquals(testPassage1, story.getOpeningPassage());
  }

  @Test
  void testGetPassage() {
    Link testLink = new Link("Back to first passage", "First passage");
    assertEquals(testPassage1, story.getPassage(testLink));
  }

  @Test
  void testGetPassages() {
    assertEquals(1, story.getPassages().size());
    assertTrue(story.getPassages().contains(testPassage1));
  }

  @Test
  void testAddPassage() {
    Passage testPassage2 = new Passage("Forrest", "You are currently in a forrest");
    story.addPassage(testPassage2);
    assertEquals(2, story.getPassages().size());
    assertTrue(story.getPassages().contains(testPassage2));
  }

  @Test
  void testRemovePassage() {
    Passage testPassage2 = new Passage("Room", "You are currently in a room");
    Link link = new Link("Room", "Room");
    story.addPassage(testPassage2);

    assertEquals(2, story.getPassages().size());
    assertTrue(story.getPassages().contains(testPassage2));



    story.removePassage(link);

    assertEquals(1, story.getPassages().size());
    assertFalse(story.getPassages().contains(testPassage2));
  }


  @Test
  void testRemoveLinkedPassage() {
    Passage testPassage2 = new Passage("Forrest", "You are currently in a forrest");
    story.addPassage(testPassage2);
    Link testPassage2Link = new Link("Forrest", "Forrest");

    assertEquals(2, story.getPassages().size());
    assertTrue(story.getPassages().contains(testPassage2));

    assertThrows(IllegalArgumentException.class, () -> story.removePassage(testPassage2Link));

    assertEquals(2, story.getPassages().size());
    assertTrue(story.getPassages().contains(testPassage2));
  }

  @Test
  void testGetBrokenLinksSize() {

    assertEquals(1, story.getBrokenLinks().size());

    Passage testPassage2 = new Passage("Forrest", "You are currently in a forrest");
    story.addPassage(testPassage2);

    assertEquals(0, story.getBrokenLinks().size());
  }

  @Test
    void testGetBrokenLinksArray() {
        Passage testPassage2 = new Passage("Forrest", "You are currently in a forrest");
        story.addPassage(testPassage2);
        Link testLink2 = new Link("go through forrest", "Other end of forrest");
        testPassage2.addLink(testLink2);

        assertEquals(1, story.getBrokenLinks().size());
        assertTrue(story.getBrokenLinks().contains(testLink2));
    }

}

