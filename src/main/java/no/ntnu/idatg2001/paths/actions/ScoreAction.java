package no.ntnu.idatg2001.paths.actions;

import no.ntnu.idatg2001.paths.player.Player;

/**
 * The ScoreAction class implements the Action interface. Contains methods
 * * for altering the player's score.
 */
public class ScoreAction implements Action {

  private final int points;

  /**
   * ScoreActions method manipulates the player's score.
   *
   * @param points the points the player currently has
   */
  public ScoreAction(int points) {
    this.points = points;
  }

  public int getPoints() {
      return points;
  }

  @Override
  public void execute(Player player) {
    player.addScore(points);
  }
}
