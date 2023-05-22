package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player.Player;


/**
 * The InventoryAction class implements the Action interface. Contains methods
 * * for altering the items in the player's inventory.
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
