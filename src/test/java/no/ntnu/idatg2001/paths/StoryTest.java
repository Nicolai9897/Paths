package no.ntnu.idatg2001.paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoryTest {

  Story story;
  Passage testPassage1;
  Link testLink1;
  Passage testPassagee2;


  @BeforeEach
  public void createStory() {
    testPassage1 = new Passage("First passage", "You are currently in the first passage");
    testLink1 = new Link("Go to forrest", "forrest");
    testPassage1.addLink(testLink1);
    Passage testPassage2 = new Passage("forrest", "You are currently in a forrest");


    story = new Story("Test story", testPassage1);
    //story.addPassage();
  }


  @Test
    void testGetters() {
      assertEquals("Test story", story.getTitle());
      assertEquals(testPassage1, story.getOpeningPassage());

      Link testLink = new Link("Back to first passage", "First passage");
      assertEquals(testPassage1, story.getPassage(testLink));

    }
}

