package no.ntnu.idatg2001.paths.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.ntnu.idatg2001.paths.Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for ScoreAction instance
 */
public class ScoreActionTest {

  ScoreAction scoreAction;
  Player player;

  /**
   * Create a player to execute the action on.
   */
  @BeforeEach
  public void createScoreAction() {
    player = new Player("Markus", 100, 20, 50);
  }

  /**
   * Test that the ScoreAction instance adds the correct amount of points to the player
   */
  @Test
  void testExecute() {
    scoreAction = new ScoreAction(20);
    scoreAction.execute(player);
    assertEquals(40, player.getScore());
  }

  /**
   * Test that the ScoreAction instance removes the correct amount of points to the player
   */
  @Test
  void testNegativeExecute() {
    scoreAction = new ScoreAction(-10);
    scoreAction.execute(player);
    assertEquals(10, player.getScore());
  }


}
