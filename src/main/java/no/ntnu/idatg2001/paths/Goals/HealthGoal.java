package no.ntnu.idatg2001.paths.Goals;

import java.util.stream.Stream;
import no.ntnu.idatg2001.paths.Player;

/**
 * The HealthGoal class implements the Goal interface. Checks if the player's
 * health is above a certain threshold.
 */
public class HealthGoal implements Goal {

  private final int MINIMUM_HEALTH = 0;

  /**
   * HealthGoal sets the threshold for the wanted health..
   *
   * @param minimumHealth the minimum health that the player wants to have
   */
  public int HealthGoal(int minimumHealth) {
    return minimumHealth;
  }


  /**
   * isFullfilled method checks if the player has achieved a given health goal.
   *
   * @param player the player
   * @return true if the player has achieved the goal, false if not.
   */
  @Override
  public boolean isFullfilled(Player player) {
    return Stream.of(player)
        .map(Player::getHealth)
        .anyMatch(health -> health <= MINIMUM_HEALTH);
  }
}
