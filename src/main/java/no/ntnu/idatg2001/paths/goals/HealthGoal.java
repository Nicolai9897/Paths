package no.ntnu.idatg2001.paths.goals;

import java.util.stream.Stream;
import no.ntnu.idatg2001.paths.player.Player;

/**
 * The HealthGoal class implements the Goal interface. Checks if the player's
 * health is above a certain threshold.
 */
public class HealthGoal implements Goal {

  private final int minimumHealth;

  /**
   * HealthGoal sets the threshold for the wanted health..
   *
   * @param minimumHealth the minimum health that the player wants to have
   */
  public HealthGoal(int minimumHealth) {
    this.minimumHealth = minimumHealth;
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
        .anyMatch(health -> health <= minimumHealth);
  }
}
