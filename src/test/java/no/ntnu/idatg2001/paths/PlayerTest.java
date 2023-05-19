package no.ntnu.idatg2001.paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for Player class
 */
public class PlayerTest {
  Player player;

  /**
   * Create a player
   */
  @BeforeEach
  public void setup() {
    player = new Player("Markus", 100, 20, 50);
  }

  /**
   * Test that the player is created with the correct name
   */
  @Test
  void testGetName() {
    assertEquals("Markus", player.getName());
  }

  /**
   * Test that the player is created with the correct health points
   */
  @Test
  void testGetHealth() {
    assertEquals(100, player.getHealth());
  }

  /**
   * Test that the player is created with the correct score
   */
  @Test
  void testGetScore() {
    assertEquals(20, player.getScore());
  }

  /**
   * Test that the player is created with the correct amount of gold
   */
  @Test
  void testGetGold() {
    assertEquals(50, player.getGold());
  }


  /**
   * Test that the addHealth method correctly adds health
   */
  @Test
  void testAddHealth() {
    player.addHealth(20);
    assertEquals(120, player.getHealth());
  }

    /**
     * Test that the addHealth method correctly adds negative health
     */
  @Test
  void testAddNegativeHealth() {
    player.addHealth(-40);
    assertEquals(60, player.getHealth());
  }

  /**
   * Test that the addScore method correctly adds score
   */
  @Test
  void testAddScore() {
    player.addScore(30);
    assertEquals(50, player.getScore());
  }

    /**
     * Test that the addScore method correctly adds negative score
     */
  @Test
  void testAddNegativeScore() {
    player.addScore(-10);
    assertEquals(10, player.getScore());
  }

    /**
     * Test that the addGold method correctly adds gold
     */
  @Test
  void testAddGold() {
    player.addGold(40);
    assertEquals(90, player.getGold());
  }

    /**
     * Test that the addGold method correctly adds negative gold
     */
  @Test
  void testAddNegativeGold() {
    player.addGold(-40);
    assertEquals(10, player.getGold());
  }

  /**
   * Test that the Inventory is created, and is empty.
   */
  @Test
  void testGetInventory() {
    assertTrue(player.getInventory().isEmpty());
  }

  /**
   * Test that the addToInventory method correctly adds an item to the inventory
   */
  @Test
  void testAddToInventory() {
    player.addToInventory("sword");
    assertTrue(player.getInventory().contains("sword"));
  }
}
