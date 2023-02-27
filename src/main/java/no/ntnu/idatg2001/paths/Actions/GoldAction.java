package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player;

/**
 * The GoldAction class implements the Action interface. Contains methods
 * for altering the player's gold.
 */
public class GoldAction implements Action{
    private int gold;


    /**
     * Method that when called through .
     *
     * @param gold the gold the player currently possesses
     * @return the int gold representing the new quantity of gold the player
     * possesses.
     */
    public int goldAction(int gold){
        return gold;
    }

    @Override
    public void execute(Player player) {

    }
}
