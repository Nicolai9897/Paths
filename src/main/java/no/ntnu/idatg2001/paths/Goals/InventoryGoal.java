package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

import java.util.ArrayList;
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
     */
    public InventoryGoal(List<String> mandatoryItems){
        this.mandatoryItems = mandatoryItems;
    }

    @Override
    public boolean isFullfilled(Player player) {
        boolean achieved = false;
        mandatoryItems = new ArrayList<>();
        List<String> playerInventory = player.getInventory();
        List<String> missingItems = new ArrayList<>();

        for(String mandatoryItem : mandatoryItems){
            if(!playerInventory.contains(mandatoryItem)){
                missingItems.add(mandatoryItem);
                achieved = false;
            }else achieved = true;
        }

        return achieved;
    }
}
