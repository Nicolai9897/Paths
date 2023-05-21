package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.application.Platform;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

public abstract class BaseController {

    protected SceneManager sceneManager;


    public BaseController(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void onMenuBarHome() {
        sceneManager.showMainMenuScene();
    }

    public void onMenuBarExit() {
        Platform.exit();
    }


}

