package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player;

public class HealthAction implements Action {

  private int health;

  public int healthAction(int health) {
    return health;
  }

  @Override
  public void execute(Player player) {

  }
}
