package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.Game;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

public class GameController extends BaseController{
    private Stage stage;
    private SceneManager scene;

    public GameController(SceneManager sceneManager) {
        super(sceneManager);
    }

    public void onBackButton(){
        sceneManager.showMainMenuScene();

    }
}
