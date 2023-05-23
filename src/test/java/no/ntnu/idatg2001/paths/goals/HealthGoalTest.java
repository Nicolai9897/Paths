package no.ntnu.idatg2001.paths.goals;

import no.ntnu.idatg2001.paths.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test class for HealthGoal instance
 */
public class HealthGoalTest {

  HealthGoal healthGoal;
  Player player;

  @BeforeEach
  public void createHealthGoal() {
    player = new Player("Markus", 100, 20, 50);
    healthGoal = new HealthGoal(0);
  }

    /**
     * Test that the HealthGoal instance returns true when the player has a health
     * equal to or bellow the minimum amount of health
     */
  @Test
  void testIsFullfilled() {
    assertFalse(healthGoal.isFullfilled(player));
    player.addHealth(-100);
    assertTrue(healthGoal.isFullfilled(player));
  }

}
