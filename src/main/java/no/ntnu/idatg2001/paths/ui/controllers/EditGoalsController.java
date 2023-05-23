package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.Game;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

public class EditGoalsController extends BaseController{


    public EditGoalsController(SceneManager sceneManager){
        super(sceneManager);
    }

    public void goalsDropDown() {
        sceneManager.showEditGoalScene();
    }

}
