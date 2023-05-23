package no.ntnu.idatg2001.paths.goals;

import java.util.stream.Stream;
import no.ntnu.idatg2001.paths.player.Player;

/**
 * ScoreGoal class implements the Goal interface. Checks if the player has
 * achieved the expected score.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
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
    public boolean isFulfilled(Player player) {
    return Stream.of(player)
        .map(Player::getScore)
        .anyMatch(score -> score >= minimumPoints);
    }
}
