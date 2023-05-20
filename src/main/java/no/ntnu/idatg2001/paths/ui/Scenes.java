package no.ntnu.idatg2001.paths.ui;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import no.ntnu.idatg2001.paths.ui.controllers.MainMenuController;



public class Scenes {
    private MainMenuController mainMenuController;

    public Scenes(MainMenuController controller){
        this.mainMenuController = controller;
    }


    public Scene mainMenu(MainMenuController controller){

        //UI controls design
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

        //Container setup
        VBox controlButtons = new VBox(10, startButton, editPlayerButton, editGoalsButton, loadStoryButton);
        VBox centerNode = new VBox(50, pathsLabel, controlButtons);
        VBox rightNode = new VBox(10, storyTitleLabel, passageList);
        rightNode.setPadding(new Insets(10));
        controlButtons.setAlignment(Pos.CENTER);
        centerNode.setAlignment(Pos.CENTER);
        rightNode.setAlignment(Pos.CENTER);

        //Pane setup
        BorderPane pane1 = new BorderPane();
        pane1.setTop(menuBar());
        pane1.setCenter(centerNode);
        pane1.setRight(rightNode);

        //button functionality
        startButton.setOnAction(e -> controller.onStartGame());
        loadStoryButton.setOnAction(e -> controller.onLoadStoryButton());
        editPlayerButton.setOnAction(e -> controller.onEditPlayer());


        Scene mainMenuScene = new Scene(pane1, 840, 600);

        return mainMenuScene;
    }

    public Scene startGameScene() {

        Label centerNode = new Label("wow it worked");
        BorderPane pane2 = new BorderPane();
        pane2.setTop(menuBar());
        pane2.setCenter(centerNode);

        Scene startGameScene = new Scene(pane2, 840, 600);

        return startGameScene;
    }


    /**
     * menuBar method creates the menubar for the application window. Returns the menubar so this can be implemented easily in every scene.
     * @return The menubar
     */
    public Node menuBar(){
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);

        MenuItem closeItem = new MenuItem("Close");
        fileMenu.getItems().add(closeItem);
        closeItem.setOnAction(e -> Platform.exit());

        return menuBar;
    }
}
