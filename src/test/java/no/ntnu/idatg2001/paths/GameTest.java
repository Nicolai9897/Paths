package no.ntnu.idatg2001.paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.idatg2001.paths.Goals.Goal;
import no.ntnu.idatg2001.paths.Goals.GoldGoal;
import no.ntnu.idatg2001.paths.Goals.HealthGoal;
import no.ntnu.idatg2001.paths.Goals.InventoryGoal;
import no.ntnu.idatg2001.paths.Goals.ScoreGoal;
import no.ntnu.idatg2001.paths.base.Link;
import no.ntnu.idatg2001.paths.base.Passage;
import no.ntnu.idatg2001.paths.base.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Game class
 */
public class GameTest {

  Game game;
  Player player;
  Story story;
  Passage testPassage1;
  Passage testPassage2;
  Link testLink1;
  Link testLink2;
  List<Goal> goals;

  /**
   * Set up the game with a story, player and goals
   */
  @BeforeEach
  void setUp() {
    // Create a new story with a passage and a link
    testPassage1 = new Passage("First passage", "You are currently in the first passage");
    testLink1 = new Link("Go to forest", "Forrest");
    testPassage1.addLink(testLink1);
    story = new Story("Test story", testPassage1);

    // Add a second passage and link to the story
    testPassage2 = new Passage("Forrest", "You are currently in forrest");
    testLink2 = new Link("Go out of", "Outside of forrest");
    testPassage2.addLink(testLink2);
    story.addPassage(testPassage2);

    // Create a new player
    player = new Player("Markus", 100, 20, 50);

    // Create a list of goals
    goals = new ArrayList<>();
    goals.add(new HealthGoal(0));
    goals.add(new GoldGoal(200));
    goals.add(new InventoryGoal(List.of("winning item")));
    goals.add(new ScoreGoal(500));

    // Create a new game
    game = new Game(player, story, goals);
  }


  /**
   * Test that the player Game class returns the correct player
   */
  @Test
  void testGetPlayer() {
    assertEquals(player, game.getPlayer());
  }

  /**
   * Test that the story Game class returns the correct story
   */
  @Test
  void testGetStory() {
    assertEquals(story, game.getStory());
  }

    /**
     * Test that the goals Game class returns the correct goals
     */
  @Test
  void testGetGoals() {
    assertEquals(goals, game.getGoals());
  }

  /**
   * Test that the begin method returns the correct passage
   */
  @Test
  void testBeginGame() {
    assertEquals(testPassage1, game.begin());
  }

  /**
   * Test that the go method returns the correct passage
   */
  @Test
  void testGetPassage() {
    assertEquals(testPassage2, game.go(testLink1));
  }


}
