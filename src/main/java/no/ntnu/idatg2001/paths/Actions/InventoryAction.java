package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player;

public class InventoryAction implements Action{

    private String item;

    public String inventoryAction(String item){
        return item;
    }

    @Override
    public void execute(Player player) {

    }
}
