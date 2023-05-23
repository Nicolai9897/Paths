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
        //Back to mainmenu or close app?
        sceneManager.showMainMenuScene();
        //or
    //  Platform.exit();
    }

    public boolean checkGameEndCondition() {
        boolean gameWon;
        //check game end condition, i.e if goal were reached

        /* if(sjekke i model om spillet er over) {
                gameWon = model.isFulfilled()
           }
           return gameWon;
         */

        return true;
    }

}
