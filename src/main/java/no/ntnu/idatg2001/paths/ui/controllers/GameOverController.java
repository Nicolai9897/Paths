package no.ntnu.idatg2001.paths.ui.controllers;

import no.ntnu.idatg2001.paths.Game;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

public class GameOverController extends BaseController{

    public GameOverController(SceneManager sceneManager) {
        super(sceneManager);
    }

    public void onRestartGame() {
        sceneManager.showGameScene();
        //TODO: functionality for actually restarting the game, resetting player etc..
    }

    public void onCloseGame() {
        sceneManager.showMainMenuScene();
    }

    public boolean checkGameEndCondition() {
        boolean gameWon;
        //check game end condition, ie if goal were reached


        return true;
    }

}
