package no.ntnu.idatg2001.paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerBuilderTest {

  Player player;


  @BeforeEach
  public void createPlayerBuilder() {
    PlayerBuilder playerBuilder = new PlayerBuilder();
    player = playerBuilder
        .withName("Markus")
        .withHealth(100)
        .withScore(40)
        .withGold(50).build();
  }


  @Test
  void testWithName() {
    assertEquals("Markus", player.getName());
  }

  @Test
  void testWithHealth() {
    assertEquals(100, player.getHealth());
  }

  @Test
  void testWithScore() {
    assertEquals(40, player.getScore());
  }

  @Test
  void testWithGold() {
    assertEquals(50, player.getGold());
  }


}
