package no.ntnu.idatg2001.paths.Goals;

import java.util.stream.Stream;
import no.ntnu.idatg2001.paths.Player;

/**
 * The GoldGoal class implements the Goal interface. Checks if the player has
 * reached a certain threshold for gold quantity.
 */
public class GoldGoal implements Goal {
  private int minimumGold = 100;

  /**
   * Sets the threshold for minimum gold that the player is supposed to have
   * and checks if the player has achieved this goal.
   *
   * @param minimumGold the minimum gold the player is supposed to have
   */
  public int GoldGoal() {
    return minimumGold;
  }


  /**
   * isFullfilled method checks if the player has achieved a given gold goal.
   * @param player the player
   * @return true if the player has achieved the goal, false if not.
   */
  @Override
  public boolean isFullfilled(Player player) {
    return Stream.of(player)
        .map(Player::getGold)
        .anyMatch(gold -> gold >= minimumGold);
  }
}
