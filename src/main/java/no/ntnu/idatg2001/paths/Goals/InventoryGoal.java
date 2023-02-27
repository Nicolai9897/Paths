package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

import java.util.List;

/**
 * The InventoryGoal class implements the Goal interface. Checks if the player
 *  * possesses all the desired items.
 */
public class InventoryGoal implements Goal{

    private List<String> mandatoryItems;

    /**
     * InventoryGoal defines a list of items that the player is expected to possess.
     *
     * @param mandatoryItems the mandatory items defines the expected items for the player to possess
     * @return the list of items that the player is expected to possess.
     */
    public List<String> inventoryGoal(List<String> mandatoryItems){
        return mandatoryItems;
    }

    @Override
    public boolean isFullfilled(Player player) {
        return false;
    }
}
