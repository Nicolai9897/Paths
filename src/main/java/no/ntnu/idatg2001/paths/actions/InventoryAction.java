package no.ntnu.idatg2001.paths.actions;

import no.ntnu.idatg2001.paths.player.Player;


/**
 * The InventoryAction class implements the Action interface. Contains methods
 *  for altering the items in the player's inventory.
 *  @author Candidate nr. 10029 & Candidate nr. 10023
 */
public class InventoryAction implements Action {

  private final String item;

  /**
   * InventoryAction manipulates the items in the players inventory.
   *
   * @param item the item that is to be added/deleted from the player's
   *             inventory
   */
  public InventoryAction(String item) {
    this.item = item;
  }

  public String getItem() {
      return item;
  }

  @Override
  public void execute(Player player) {
    player.addToInventory(item);
  }
}
