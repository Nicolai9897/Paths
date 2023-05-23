package no.ntnu.idatg2001.paths.goals;

import java.util.stream.Stream;
import no.ntnu.idatg2001.paths.player.Player;

/**
 * The GoldGoal class implements the Goal interface. Checks if the player has
 * reached a certain threshold for gold quantity.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class GoldGoal implements Goal {
  private final int minimumGold;

  /**
   * Sets the threshold for minimum gold that the player is supposed to have
   * and checks if the player has achieved this goal.
   */
  public GoldGoal(int minimumGold) {
    this.minimumGold = minimumGold;
  }


  /**
   * isFullfilled method checks if the player has achieved a given gold goal.
   * @param player the player
   * @return true if the player has achieved the goal, false if not.
   */
  @Override
  public boolean isFulfilled(Player player) {
    return Stream.of(player)
        .map(Player::getGold)
        .anyMatch(gold -> gold >= minimumGold);
  }
}
