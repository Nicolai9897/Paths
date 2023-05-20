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

// TODO: Refactor UI implementation for modularization and scalability.

/**
 * The PathsApp class creates the User interface of the application
 */
public class PathsApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Story story;
        Game game;

        primaryStage.setTitle("Paths");
        primaryStage.setWidth(840);
        primaryStage.setHeight(600);

        //Configurations for the first scene
        Button startButton = new Button("Start Game");
        startButton.setPrefSize(200,100);
        startButton.setFont(new Font(20));
        Button editPlayerButton = new Button("Edit player");
        Button editGoalsButton = new Button("Edit goals");
        Button loadStoryButton = new Button("Load Story");

        Label pathsLabel = new Label("Paths");
        pathsLabel.setFont(Font.font("Comic Sans MS", 72));
        Label storyTitleLabel = new Label("story title example");
        storyTitleLabel.setFont(Font.font("Comic Sans MS", 16));

        ListView<String> passageList = new ListView<>();
        passageList.setPrefSize(30,200);
        passageList.setStyle("-fx-border-color:black;");

        VBox controlButtons = new VBox(10, startButton, editPlayerButton, editGoalsButton, loadStoryButton);
        VBox centerNode = new VBox(50, pathsLabel, controlButtons);
        VBox rightNode = new VBox(10, storyTitleLabel, passageList);
        rightNode.setPadding(new Insets(10));

        controlButtons.setAlignment(Pos.CENTER);
        centerNode.setAlignment(Pos.CENTER);
        rightNode.setAlignment(Pos.CENTER);
        BorderPane pane1 = new BorderPane();
        pane1.setTop(menuBar());
        pane1.setCenter(centerNode);
        pane1.setRight(rightNode);
        Scene scene1 = new Scene(pane1, 840, 600);



        // Configurations for second scene
        Label sceneTwoText = new Label("Second scene");
        Button backButton = new Button("Back");

        VBox scene2Node = new VBox(10, sceneTwoText, backButton);
        scene2Node.setAlignment(Pos.CENTER);
        BorderPane pane2 = new BorderPane();
        pane2.setTop(menuBar());
        pane2.setCenter(scene2Node);
        Scene scene2 = new Scene(pane2, 300, 300);

        // Actions for the buttons in scene1
        startButton.setOnAction(e -> primaryStage.setScene(scene2));
        loadStoryButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Story File");
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                // Load the story from the file. Should also check that it is a .paths file

            }
        });


        // Actions for the buttons in scene2
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