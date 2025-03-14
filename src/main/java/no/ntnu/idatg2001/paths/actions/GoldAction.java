package no.ntnu.idatg2001.paths.actions;

import no.ntnu.idatg2001.paths.player.Player;

/**
 * The GoldAction class implements the Action interface. Contains methods
 * for altering the player's gold.
 * @author Candidate nr. 10029 & Candidate nr. 10023
 */
public class GoldAction implements Action {
  private final int gold;


  /**
   * Constructor for GoldAction. Allows for manipulation of the player's gold.
   *
   * @param gold the gold the player currently possesses
   */
  public GoldAction(int gold) {
    this.gold = gold;
  }

  public int getGold() {
      return gold;
  }

  @Override
  public void execute(Player player) {
    player.addGold(gold);
  }
}
