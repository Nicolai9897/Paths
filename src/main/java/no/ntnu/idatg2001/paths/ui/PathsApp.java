package no.ntnu.idatg2001.paths.ui;

import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.Game;
import no.ntnu.idatg2001.paths.base.Passage;
import no.ntnu.idatg2001.paths.base.Story;
import no.ntnu.idatg2001.paths.ui.controllers.MainMenuController;
import no.ntnu.idatg2001.paths.ui.dialogs.EditPlayerDialog;

// TODO: Refactor UI implementation for modularization and scalability.

/**
 * The PathsApp class creates the User interface of the application
 */
public class PathsApp extends Application {
    MainMenuController controller;
    Scenes scene;

    @Override
    public void start(Stage primaryStage) {

        scene = new Scenes(controller);
        controller = new MainMenuController(primaryStage, scene);
        Scene mainMenuScene = scene.mainMenu(controller);
        primaryStage.setTitle("Paths");
        primaryStage.setWidth(840);
        primaryStage.setHeight(600);
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();





       /* // Configurations for second scene
        Label sceneTwoText = new Label("Second scene");
        Button backButton = new Button("Back");

        VBox scene2Node = new VBox(10, sceneTwoText, backButton);
        scene2Node.setAlignment(Pos.CENTER);
        BorderPane pane2 = new BorderPane();
        pane2.setTop(scene.menuBar());
        pane2.setCenter(scene2Node);
        Scene scene2 = new Scene(pane2, 300, 300);




        editPlayerButton.setOnAction(e -> {
            EditPlayerDialog playerDialog = new EditPlayerDialog();
            playerDialog.showDialog();
        });


        // Actions for the buttons in scene2
        backButton.setOnAction(e -> primaryStage.setScene(scene1));

     */
    }




    public static void appMain(String[] args) {
        launch(args);
    }
}