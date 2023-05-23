package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.MainMenuController;

public class MainMenuScene extends BaseScene{

    private final MainMenuController mainMenuController;
    private Button startButton;

    public MainMenuScene(SceneManager sceneManager, Stage stage,MainMenuController controller) {
        super(sceneManager, stage, controller);
        this.mainMenuController = controller;
    }

    @Override
    protected void setupScene() {
        //UI controls design
        startButton = new Button("Start Game");
        startButton.setPrefSize(200,100);
        startButton.setFont(new Font(20));
        startButton.setFocusTraversable(true);
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
        BorderPane pane = new BorderPane();
        pane.setTop(menuBar);
        pane.setCenter(centerNode);
        pane.setRight(rightNode);

        //button functionality
        startButton.setOnAction(e -> mainMenuController.onStartGame());
        loadStoryButton.setOnAction(e -> mainMenuController.onLoadStoryButton());
        editPlayerButton.setOnAction(e -> mainMenuController.onEditPlayer());
        editGoalsButton.setOnAction(e -> mainMenuController.onEditGoals());

        scene = new Scene(pane, 840, 600);
    }

    public Button getFocusButton() {
        return startButton;
    }

}
