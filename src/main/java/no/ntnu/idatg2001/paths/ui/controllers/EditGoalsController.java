package no.ntnu.idatg2001.paths.ui.controllers;

import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

public class EditGoalsController extends BaseController{


    public EditGoalsController(SceneManager sceneManager){
        super(sceneManager);
    }

    public void onBackButton() {
        sceneManager.showMainMenuScene();
    }

}
