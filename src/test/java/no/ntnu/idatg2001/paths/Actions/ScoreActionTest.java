package no.ntnu.idatg2001.paths.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.ntnu.idatg2001.paths.Player;

public class ScoreActionTest {

  ScoreAction scoreAction;
  Player player;

  @org.junit.jupiter.api.BeforeEach
  public void createScoreAction() {
    player = new Player("Markus", 100, 20, 50);
  }

  @org.junit.jupiter.api.Test
  void testExecute() {
    scoreAction = new ScoreAction(100);
    scoreAction.execute(player);
    assertEquals(120, player.getScore());
  }
}
