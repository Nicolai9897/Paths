package no.ntnu.idatg2001.paths.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import no.ntnu.idatg2001.paths.Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for InventoryAction instance
 */
class InventoryActionTest {
  InventoryAction inventoryAction;
  Player player;

  /**
   * Create a player to execute the action on.
   */
  @BeforeEach
  public void createInventoryAction() {
    player = new Player("Markus", 100, 20, 50);
  }

  /**
   * Test that the InventoryAction instance adds the correct item to the player
   */
  @Test
  void testExecute() {
    inventoryAction = new InventoryAction("sword");
    inventoryAction.execute(player);
    assertTrue(player.getInventory().contains("sword"));
  }


}
