package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player;

/**
 * The HealthAction class implements the Action interface. Contains methods
 * for altering the player's health.
 */
public class HealthAction implements Action {

  private int health;

  /**
   * HealthAction manipulates the player's health.
   *
   * @param health the health that the player currently has left.
   */
  public HealthAction(int health) {
    this.health = health;
  }

  @Override
  public void execute(Player player) {
    player.addHealth(health);
  }
}
