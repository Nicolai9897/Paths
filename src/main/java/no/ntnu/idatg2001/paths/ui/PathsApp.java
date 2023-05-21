package no.ntnu.idatg2001.paths.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.EditGoalsController;
import no.ntnu.idatg2001.paths.ui.controllers.MainMenuController;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

// TODO: Refactor UI implementation for modularization and scalability.

/**
 * The PathsApp is the application entry point
 */
public class PathsApp extends Application {
    private SceneManager sceneManager;

    @Override
    public void start(Stage primaryStage) {

        sceneManager = new SceneManager(primaryStage);
        sceneManager.showMainMenuScene();
        primaryStage.setTitle("Paths");
        primaryStage.setWidth(840);
        primaryStage.setHeight(600);
        primaryStage.show();

    }

    public static void appMain(String[] args) {
        launch(args);
    }
}