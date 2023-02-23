package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

import java.util.List;

public class InventoryGoal implements Goal{

    private List<String> mandatoryItems;

    public List<String> inventoryGoal(List<String> mandatoryItems){
        return mandatoryItems;
    }

    @Override
    public boolean isFullfilled(Player player) {
        return false;
    }
}
