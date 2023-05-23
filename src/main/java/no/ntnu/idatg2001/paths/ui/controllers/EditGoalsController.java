package no.ntnu.idatg2001.paths.ui.controllers;

import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

/**
 * Controller for the EditGoalsScene. Handles the actions for when something happens in the scene.
 * Inherits from the Super Class BaseController.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class EditGoalsController extends BaseController{

    /**
     * Constructor for EditGoalsController.
     * @param sceneManager
     */
    public EditGoalsController(SceneManager sceneManager){
        super(sceneManager);
    }

    /**
     * Handles actions for when the back button is pressed in the corresponding scene.
     */
    public void onBackButton() {
        sceneManager.showMainMenuScene();
    }

}
