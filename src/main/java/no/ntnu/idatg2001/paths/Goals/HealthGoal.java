package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

/**
 * The HealthGoal class implements the Goal interface. Checks if the player's
 * health is above a certain threshold.
 */
public class HealthGoal implements Goal {

  private int minimumHealth;

  /**
   * HealthGoal sets the threshold for the wanted health..
   *
   * @param minimumHealth the minimum health that the player wants to have
   */
  public HealthGoal(int minimumHealth) {
    this.minimumHealth = minimumHealth;
  }

  @Override
  public boolean isFullfilled(Player player) {
    boolean achieved = false;
    if (player.getGold() >= minimumHealth) {
      achieved = true;
    }

    return achieved;
  }

}
