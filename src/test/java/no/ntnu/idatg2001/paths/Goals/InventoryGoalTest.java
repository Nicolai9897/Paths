package no.ntnu.idatg2001.paths.Goals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import no.ntnu.idatg2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryGoalTest {
  private List<String> mandatoryItems;
  private InventoryGoal inventoryGoal;

  Player player;

  /**
   * Create a new inventory goal, and a new player.
   */
  @BeforeEach
  public void createInventoryGoal() {
    mandatoryItems = List.of("sword", "shield", "armor");
    inventoryGoal = new InventoryGoal(mandatoryItems);
    player = new Player("Markus", 100, 20, 50);
  }

  /**
   * Test if the inventory goal is fullfilled.
   */
  @Test
  void testIsFullfilled() {
    assertEquals(false, inventoryGoal.isFullfilled(player));
    player.addToInventory("sword");
    assertEquals(true, inventoryGoal.isFullfilled(player));
    player.addToInventory("shield");
    assertEquals(true, inventoryGoal.isFullfilled(player));
  }
}