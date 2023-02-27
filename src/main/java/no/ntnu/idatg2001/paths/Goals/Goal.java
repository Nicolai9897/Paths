package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

/**
 * The interface Goal. Makes it possible to check whether the player
 * has achieved the given goals.
 */
public interface Goal {
    /**
     * isFullfilled method checks if the player has achieved a given goal.
     *
     * @param player the player
     * @return the boolean false/true based on whether the player has achieved
     * a goal or not.
     */
    public boolean isFullfilled(Player player);
}
