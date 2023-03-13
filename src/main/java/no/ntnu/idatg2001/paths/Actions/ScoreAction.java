package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player;

/**
 * The ScoreAction class implements the Action interface. Contains methods
 * * for altering the player's score.
 */
public class ScoreAction implements Action {

  private int points;

  /**
   * ScoreActions method manipulates the player's score.
   *
   * @param points the points the player currently has
   */
  public ScoreAction(int points) {
    this.points = points;
  }

  @Override
  public void execute(Player player) {
    player.addScore(points);
  }
}
