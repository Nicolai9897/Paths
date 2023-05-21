package no.ntnu.idatg2001.paths.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.EditGoalsController;
import no.ntnu.idatg2001.paths.ui.controllers.MainMenuController;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

// TODO: Refactor UI implementation for modularization and scalability.

/**
 * The PathsApp class creates the User interface of the application
 */
public class PathsApp extends Application {
    MainMenuController controller;
    SceneManager scene;

    @Override
    public void start(Stage primaryStage) {

        scene = new SceneManager(controller, new EditGoalsController(primaryStage, scene));
        controller = new MainMenuController(primaryStage, scene);
        Scene mainMenuScene = scene.mainMenu(controller);
        primaryStage.setTitle("Paths");
        primaryStage.setWidth(840);
        primaryStage.setHeight(600);
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();

    }




    public static void appMain(String[] args) {
        launch(args);
    }
}