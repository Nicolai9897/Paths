package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;


public class MenuBarController {
    private Stage stage;
    private SceneManager scene;

    public MenuBarController(Stage stage, SceneManager scene){
        this.stage = stage;
        this.scene = scene;
    }

    public void onHome() {
        Scene mainMenuScene = scene.mainMenu(new MainMenuController(stage, scene));
        stage.setScene(mainMenuScene);
    }

    public void onExit() {
        Platform.exit();
    }
}
