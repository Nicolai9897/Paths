package no.ntnu.idatg2001.paths.Goals;

import java.util.stream.Stream;
import no.ntnu.idatg2001.paths.Player;

/**
 * ScoreGoal class implements the Goal interface. Checks if the player has
 * achieved the expected score.
 */
public class ScoreGoal implements Goal {

  private final int minimumPoints;

  /**
   * Score goal int.
   *
   * @param minimumPoints the minimum points the player is expected to have.
   */
  public ScoreGoal(int minimumPoints) {
    this.minimumPoints = minimumPoints;
  }

    /**
     * isFullfilled method checks if the player has achieved a given score goal.
     *
     * @param player the player
     * @return true if the player has achieved the goal, false if not.
     */
    @Override
    public boolean isFullfilled(Player player) {
    return Stream.of(player)
        .map(Player::getScore)
        .anyMatch(score -> score >= minimumPoints);
    }
}
