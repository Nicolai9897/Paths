package no.ntnu.idatg2001.paths.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.ntnu.idatg2001.paths.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for HealthAction instance
 */
public class HealthActionTest {

  HealthAction healthAction;
  Player player;

  /**
   * Create a player to execute the action on.
   */
  @BeforeEach
  public void createHealthAction(){
    player = new Player("Markus", 100, 20, 50);
  }

  /**
   * Test that the HealthAction instance adds the correct amount of health to the player
   */
  @Test
  void testExecute(){
      healthAction = new HealthAction(100);
      healthAction.execute(player);
      assertEquals(200, player.getHealth());
  }

    /**
     * Test that the HealthAction instance removes the correct amount of health to the player
     */
  @Test
  void testExecuteNegative(){
      healthAction = new HealthAction(-10);
      healthAction.execute(player);
      assertEquals(90, player.getHealth());
  }


}
