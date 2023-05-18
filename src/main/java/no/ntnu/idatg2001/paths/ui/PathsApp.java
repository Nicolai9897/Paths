package no.ntnu.idatg2001.paths.ui;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PathsApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Paths");

        //Configurations for the first scene
        Button continueButton = new Button("Continue");
        Label welcome = new Label("Welcome to Paths!");

        VBox rootNode = new VBox(100, welcome, continueButton);
        rootNode.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(rootNode, 600, 600);

        primaryStage.setScene(scene1);

        // Configurations for second scene
        Label sceneTwoText = new Label("Second scene");
        Button backButton = new Button("Back");

        VBox scene2Node = new VBox(10, sceneTwoText, backButton);
        scene2Node.setAlignment(Pos.CENTER);

        Scene scene2 = new Scene(scene2Node, 300, 300);

        // Actions for the buttons
        continueButton.setOnAction(e -> primaryStage.setScene(scene2));
        backButton.setOnAction(e -> primaryStage.setScene(scene1));

        primaryStage.show();
    }



    public static void appMain(String[] args) {
        launch(args);
    }
}