package no.ntnu.idatg2001.paths.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import no.ntnu.idatg2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryActionTest {
  InventoryAction inventoryAction;
  Player player;

  @BeforeEach
  public void createInventoryAction(){
    player = new Player("Markus", 100, 20, 50);
  }

  @Test
  void testExecute(){
    inventoryAction = new InventoryAction("sword");
    inventoryAction.execute(player);
    assertTrue(player.getInventory().contains("sword"));
  }


}
