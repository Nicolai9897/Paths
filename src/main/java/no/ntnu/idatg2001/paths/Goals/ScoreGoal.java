package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

/**
 * ScoreGoal class implements the Goal interface. Checks if the player has
 * achieved the expected score.
 */
public class ScoreGoal implements Goal{

    private int minimumPoints;

    /**
     * Score goal int.
     *
     * @param minimumPoints the minimum points the player is expected to have.
     */
    public ScoreGoal(int minimumPoints){
        this.minimumPoints = minimumPoints;
    }
    @Override
    public boolean isFullfilled(Player player) {
        boolean achieved = false;
        if(player.getGold() >= minimumPoints){
            achieved = true;
        }

        return achieved;
    }
}
