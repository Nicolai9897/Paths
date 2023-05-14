package no.ntnu.idatg2001.paths;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassageTest {
  Passage passage;
  Link testLink1 = new Link("A mysterious second passage is in front of you", "second passage");
  Link testLink2 = new Link("A boring third passage is in front of you", "third passage");

  @BeforeEach
  public void createPassage() {


    passage = new Passage("First passage", "You are currently in the first passage");
  }

  @Test
  void getTitleTest() {
    assertEquals("First passage", passage.getTitle());
  }

  @Test
  void getContentTest() {
    assertEquals("You are currently in the first passage", passage.getContent());
  }

  @Test
  void addLinkTest() {
    passage.addLink(testLink1);
    passage.addLink(testLink2);
    assertEquals(2, passage.getLinks().size());
  }

  @Test
  void getLinksTest() {
    passage.addLink(testLink1);
    passage.addLink(testLink2);
    assertEquals("third passage", passage.getLinks().get(1).getReference());
    assertEquals("A mysterious second passage is in front of you", passage.getLinks().get(0).getText());
  }

  @Test
  void hasLinkTest() {
    assertEquals(false, passage.hasLink());
    passage.addLink(testLink1);
    assertEquals(true, passage.hasLink());
  }


}
