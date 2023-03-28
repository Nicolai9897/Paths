package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player;

/**
 * The GoldAction class implements the Action interface. Contains methods
 * for altering the player's gold.
 */
public class GoldAction implements Action {
  private int gold;


  /**
   * Constructor for GoldAction. Allows for manipulation of the player's gold.
   *
   * @param gold the gold the player currently possesses
   */
  public GoldAction(int gold) {
    this.gold += gold;
  }

  @Override
  public void execute(Player player) {
    player.addGold(gold);
  }
}
