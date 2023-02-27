package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player;

/**
 * The InventoryAction class implements the Action interface. Contains methods
 *  * for altering the items in the player's inventory.
 */
public class InventoryAction implements Action{

    private String item;

    /**
     * InventoryAction manipulates the items in the players inventory.
     *
     * @param item the item that is to be added/deleted from the player's
     *             inventory
     * @return the string item the added item
     */
    public String inventoryAction(String item){
        return item;
    }

    @Override
    public void execute(Player player) {

    }
}
