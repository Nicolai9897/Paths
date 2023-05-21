package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.application.Platform;
import javafx.scene.Scene;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

public abstract class BaseController {

    protected SceneManager sceneManager;

    public BaseController(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void menuBarHome() {
        sceneManager.showMainMenuScene();
    }

    public void menuBarExit() {
        Platform.exit();
    }


}

