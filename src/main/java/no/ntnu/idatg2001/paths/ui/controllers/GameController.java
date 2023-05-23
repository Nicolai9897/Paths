package no.ntnu.idatg2001.paths.ui.controllers;

import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

/**
 * Controller for the GameScene. Handles the actions for when something happens in the scene.
 * Inherits from the Super Class BaseController.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class GameController extends BaseController{

    /**
     * Constructor for the GameController.
     * @param sceneManager
     */
    public GameController(SceneManager sceneManager) {
        super(sceneManager);
    }
    /**
     * Handles the action for when the back button is pressed.
     * Shows the MainMenuScene through the sceneManager.
     */
    public void onBackButton(){
        sceneManager.showMainMenuScene();

    }
}
