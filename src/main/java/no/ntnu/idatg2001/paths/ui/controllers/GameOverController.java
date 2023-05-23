package no.ntnu.idatg2001.paths.ui.controllers;

import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

/**
 * Controller for the GameOverScene. Handles the actions for when something happens in the scene.
 * Inherits from the Super Class BaseController.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class GameOverController extends BaseController{

    /**
     * Constructor for the GameOverController.
     */
    public GameOverController(SceneManager sceneManager) {
        super(sceneManager);
    }

    /**
     * Handles actoin for when the restart game button is pressed.
     */
    public void onRestartGame() {
        sceneManager.showGameScene();
        //TODO: functionality for actually restarting the game, resetting player etc..
    }

    /**
     * Handles action for when the close game button is pressed.
     */
    public void onCloseGame() {
        sceneManager.showMainMenuScene();
    }

    public boolean checkGameEndCondition() {
        boolean gameWon;
        //check game end condition, ie if goal were reached


        return true;
    }

}
