package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Game;
import no.ntnu.idatg2001.paths.Player;
import java.util.List;

/**
 * The GoldGoal class implements the Goal interface. Checks if the player has
 * reached a certain threshold for gold quantity.
 */
public class GoldGoal implements Goal {
  private int minimumGold;

  /**
   * Sets the threshold for minimum gold that the player is supposed to have
   * and checks if the player has achieved this goal.
   *
   * @param minimumGold the minimum gold the player is supposed to have
   */
  public GoldGoal(int minimumGold) {
    this.minimumGold = minimumGold;
  }

  @Override
  public boolean isFullfilled(Player player) {
    boolean achieved = false;
    if (player.getGold() >= minimumGold) {
      achieved = true;
    }

    return achieved;
  }
}
