package no.ntnu.idatg2001.paths.actions;

import no.ntnu.idatg2001.paths.player.Player;

/**
 * The HealthAction class implements the Action interface. Contains methods
 * for altering the player's health.
 */
public class HealthAction implements Action {

  private final int health;

  /**
   * HealthAction manipulates the player's health.
   *
   * @param health the health that the player currently has left.
   */
  public HealthAction(int health) {
    this.health = health;
  }

  public int getHealth() {
    return health;
  }

  @Override
  public void execute(Player player) {
    player.addHealth(health);
  }
}
