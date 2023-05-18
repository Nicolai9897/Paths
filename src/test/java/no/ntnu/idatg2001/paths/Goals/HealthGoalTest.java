package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HealthGoalTest {

  HealthGoal healthGoal;
  Player player;

  @BeforeEach
  public void createHealthGoal() {
    player = new Player("Markus", 100, 20, 50);
    healthGoal = new HealthGoal(0);
  }

  @Test
  void testIsFullfilled() {
    assertFalse(healthGoal.isFullfilled(player));
    player.addHealth(-100);
    assertTrue(healthGoal.isFullfilled(player));
  }

}
