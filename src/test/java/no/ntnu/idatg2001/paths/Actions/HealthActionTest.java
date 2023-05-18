package no.ntnu.idatg2001.paths.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.ntnu.idatg2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HealthActionTest {

  HealthAction healthAction;
  Player player;

  @BeforeEach
  public void createHealthAction(){
    player = new Player("Markus", 100, 20, 50);
  }

  @Test
  void testExecute(){
      healthAction = new HealthAction(100);
      healthAction.execute(player);
      assertEquals(200, player.getHealth());
  }

  @Test
  void testExecuteNegative(){
      healthAction = new HealthAction(-10);
      healthAction.execute(player);
      assertEquals(90, player.getHealth());
  }


}
