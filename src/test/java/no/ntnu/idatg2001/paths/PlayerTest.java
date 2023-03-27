package no.ntnu.idatg2001.paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public  class PlayerTest {
  Player player;

  @BeforeEach
  public void  createPlayet(){
    player = new Player("Markus", 100, 20, 50);
  }

  @Test
  void testGetters(){
    //test getName
    assertEquals("Markus", player.getName());
    //Test GetHealth
    assertEquals(100, player.getHealth());
    //test getScore
    assertEquals(20, player.getScore());
    //test get gold
    assertEquals(50, player.getGold());
  }

  @Test
  void testAddHealth(){
    player.addHealth(20);
    assertEquals(120, player.getHealth());
    player.addHealth(-40);
    assertEquals(80, player.getHealth());
  }

  @Test
  void testAddScore(){
    player.addScore(30);
    assertEquals(50, player.getScore());
    player.addScore(-40);
    assertEquals(10, player.getScore());
  }

  @Test
  void testAddGold(){
    player.addGold(40);
    assertEquals(90, player.getGold());
    player.addGold(-80);
    assertEquals(10, player.getGold());
  }

  @Test
  void testAddToInventory(){
    player.addToInventory("sword");
    assertTrue(player.getInventory().contains("sword"));
  }
}
