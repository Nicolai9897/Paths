package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player;

/**
 * The ScoreAction class implements the Action interface. Contains methods
 *  * for altering the player's score.
 */
public class ScoreAction implements Action {

    private int points;

    /**
     * ScoreActions method manipulates the player's score.
     *
     * @param points the points the player currently has
     * @return the int points the new amount of points that the player has
     */
    public int scoreActions(int points){
        return points;
    }
    @Override
    public void execute(Player player) {

    }
}
