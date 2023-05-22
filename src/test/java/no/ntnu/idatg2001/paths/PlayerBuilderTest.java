package no.ntnu.idatg2001.paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.ntnu.idatg2001.paths.Player.Player;
import no.ntnu.idatg2001.paths.Player.PlayerBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for PlayerBuilder class
 */
public class PlayerBuilderTest {

  Player player;


  /**
   * Create a player using the player builder
   */
  @BeforeEach
  public void createPlayerBuilder() {
    PlayerBuilder playerBuilder = new PlayerBuilder();
    player = playerBuilder
        .withName("Markus")
        .withHealth(100)
        .withScore(40)
        .withGold(50).build();
  }


  /**
   * Test that the player is created with the correct name
   */
  @Test
  void testWithName() {
    assertEquals("Markus", player.getName());
  }

  /**
   * Test that the player is created with the correct health points
   */
  @Test
  void testWithHealth() {
    assertEquals(100, player.getHealth());
  }

  /**
   * Test that the player is created with the correct score
   */
  @Test
  void testWithScore() {
    assertEquals(40, player.getScore());
  }

  /**
   * Test that the player is created with the correct amount of gold
   */
  @Test
  void testWithGold() {
    assertEquals(50, player.getGold());
  }


}
