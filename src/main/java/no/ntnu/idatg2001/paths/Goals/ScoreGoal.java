package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

/**
 * ScoreGoal class implements the Goal interface. Checks if the player has
 * achieved the expected socre.
 */
public class ScoreGoal implements Goal{

    private int minimumPoints;

    /**
     * Score goal int.
     *
     * @param minimumPoints the minimum points the player is expected to have.
     * @return the int score the minimum points the player is expected to have.
     */
    public int scoreGoal(int minimumPoints){
        return minimumPoints;
    }
    @Override
    public boolean isFullfilled(Player player) {
        return false;
    }
}
