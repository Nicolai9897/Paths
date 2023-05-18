package no.ntnu.idatg2001.paths;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassageTest {
  Passage passage;
  Link testLink1 = new Link("A mysterious second passage is in front of you",
      "second passage");
  Link testLink2 = new Link("A boring third passage is in front of you",
      "third passage");

  @BeforeEach
  public void createPassage() {
    passage = new Passage("First passage", "You are currently in the first passage");
  }

  @Test
  void testGetTitle() {
    assertEquals("First passage", passage.getTitle());
  }

  @Test
  void testGetContent() {
    assertEquals("You are currently in the first passage", passage.getContent());
  }

  @Test
  void testAddLink() {
    passage.addLink(testLink1);
    passage.addLink(testLink2);
    assertEquals(2, passage.getLinks().size());
  }

  @Test
  void testGetLinks() {
    passage.addLink(testLink1);
    passage.addLink(testLink2);
    assertEquals("third passage", passage.getLinks().get(1).getReference());
    assertEquals("A mysterious second passage is in front of you",
        passage.getLinks().get(0).getText());
  }

  @Test
  void testHasLink() {
    assertFalse(passage.hasLink());
    passage.addLink(testLink1);
    assertTrue(passage.hasLink());
  }

  @Test
  void testEquals() {
    Passage passage2 = new Passage("First passage",
        "You are currently in the first passage");
    assertTrue(passage.equals(passage2));
  }

  @Test
  void testNotEquals() {
    Passage passage2 = new Passage("Not the first passage",
        "You are currently not in the first passage");
    assertFalse(passage.equals(passage2));
  }

  @Test
  void testHashCode() {
    Passage passage2 = new Passage("First passage",
        "You are currently in the first passage");
    assertEquals(passage.hashCode(), passage2.hashCode());
  }

  @Test
  void testNegativeHashCode() {
    Passage passage2 = new Passage("Not the first passage",
        "You are currently not in the first passage");
    assertNotEquals(passage.hashCode(), passage2.hashCode());
  }

}
