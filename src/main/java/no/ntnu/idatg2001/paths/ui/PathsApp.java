package no.ntnu.idatg2001.paths.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO: Refactor UI implementation for modularization and scalability.

/**
 * The PathsApp class creates the User interface of the application
 */
public class PathsApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Paths");

        //Configurations for the first scene
        Button continueButton = new Button("Continue");
        Label welcome = new Label("Welcome to Paths!");

        VBox scene1Node = new VBox(50, welcome, continueButton);
        scene1Node.setAlignment(Pos.CENTER);
        BorderPane pane1 = new BorderPane();
        pane1.setTop(menuBar());
        pane1.setCenter(scene1Node);
        Scene scene1 = new Scene(pane1, 600, 600);



        // Configurations for second scene
        Label sceneTwoText = new Label("Second scene");
        Button backButton = new Button("Back");

        VBox scene2Node = new VBox(10, sceneTwoText, backButton);
        scene2Node.setAlignment(Pos.CENTER);
        BorderPane pane2 = new BorderPane();
        pane2.setTop(menuBar());
        pane2.setCenter(scene2Node);
        Scene scene2 = new Scene(pane2, 300, 300);

        // Actions for the buttons
        continueButton.setOnAction(e -> primaryStage.setScene(scene2));
        backButton.setOnAction(e -> primaryStage.setScene(scene1));

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    /**
     * menuBar method creates the menubar for the application window. Returns the menubar so this can be implemented easily in every scene.
     * @return The menubar
     */
    private Node menuBar(){
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);

        MenuItem closeItem = new MenuItem("Close");
        fileMenu.getItems().add(closeItem);
        closeItem.setOnAction(e -> Platform.exit());

        return menuBar;
    }


    public static void appMain(String[] args) {
        launch(args);
    }
}