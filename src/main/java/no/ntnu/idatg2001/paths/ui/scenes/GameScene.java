package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.GameController;

public class GameScene extends BaseScene{

    private GameController gameController;

    public GameScene(SceneManager sceneManager, Stage stage, GameController controller){
        super(sceneManager, stage);
        this.gameController = controller;
    }
    @Override
    protected void setupScene() {
        //TODO: less hardcoded coordinate values??
        //Top anchor
        Label storyTitle = new Label("Story title");
        storyTitle.setFont(new Font(72));
        VBox titleBox = new VBox(storyTitle);
        titleBox.setPrefWidth(400.0);
        titleBox.setPrefHeight(100.0);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setStyle("-fx-border-color:black;");

        //Passage title and text
        Label passageTitle = new Label("Passage Title");
        Label passageText = new Label("1\n2\n3\n4\n5\n6\n7\n8");
        ScrollPane passageTextPane = new ScrollPane(passageText);
        passageTextPane.setPrefWidth(500);
        passageTextPane.setPrefHeight(150);
        VBox titleAndText = new VBox(20, passageTitle, passageTextPane);

        //Links and confirm button
        Label chooseLink = new Label("Choose link:");
        ObservableList<String> passages = FXCollections.observableArrayList(
                "Passage 1", "Passage 2", "Passage 3"
        );
        ListView<String> listView = new ListView<>(passages);
        listView.setPrefHeight(75);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Button confirmButton = new Button("Confirm");
        VBox passagesAndConfirm = new VBox(20, chooseLink, listView, confirmButton);
        passagesAndConfirm.setAlignment(Pos.CENTER);


        //Player stats
        Label playerStats = new Label("Player statistics");
        Label goldLabel = new Label("Gold: ");
        Label playerGold = new Label("xxxx");
        Label healthLabel = new Label("Health: ");
        Label playerHealth = new Label("xxxx");
        Label scoreLabel = new Label("Score: ");
        Label playerScore = new Label("xxxx");
        GridPane grid = new GridPane();
        grid.add(goldLabel, 0, 0);
        grid.add(playerGold, 1, 0);
        grid.add(healthLabel, 0, 1);
        grid.add(playerHealth, 1, 1);
        grid.add(scoreLabel, 0, 2);
        grid.add(playerScore, 1, 2);
        VBox leftPlayerStats = new VBox(grid);
        leftPlayerStats.setAlignment(Pos.CENTER);

        Label inventoryLabel = new Label("Inventory");
        ListView<String> inventoryList = new ListView<>();
        VBox playerRightStats = new VBox(10, inventoryLabel, inventoryList);
        playerRightStats.setAlignment(Pos.CENTER);
        inventoryList.setStyle("-fx-border-color:black;");
        inventoryList.getItems().add("Item 1");
        inventoryList.getItems().add("Item 2");
        HBox playerStatsBox = new HBox(20, leftPlayerStats,playerRightStats);
        playerStatsBox.setPrefHeight(100);
        playerStatsBox.setStyle("-fx-border-color:black;");

        VBox playerStatistics = new VBox(10, playerStats, playerStatsBox);

        //Story Goals
        Label storyGoalLabel = new Label("Story Goals");
        ListView<String> storyGoals = new ListView<>();
        storyGoals.getItems().add("Goal 1");
        storyGoals.getItems().add("Goal 2");

        VBox storyBox = new VBox(10, storyGoalLabel, storyGoals);
        storyBox.setAlignment(Pos.CENTER);
        storyBox.setPrefHeight(100);


        AnchorPane pane = new AnchorPane();
        AnchorPane.setTopAnchor(menuBar, 0.0);
        AnchorPane.setLeftAnchor(menuBar, 0.0);
        AnchorPane.setTopAnchor(titleBox, 0.0);
        AnchorPane.setLeftAnchor(titleBox, 220.0);
        AnchorPane.setTopAnchor(titleAndText, 120.0);
        AnchorPane.setLeftAnchor(titleAndText, 20.0);
        AnchorPane.setTopAnchor(passagesAndConfirm, 120.0);
        AnchorPane.setRightAnchor(passagesAndConfirm, 20.0);
        AnchorPane.setBottomAnchor(playerStatistics, 25.0);
        AnchorPane.setLeftAnchor(playerStatistics, 25.0);
        AnchorPane.setBottomAnchor(storyBox, 25.0);
        AnchorPane.setRightAnchor(storyBox, 25.0);

        pane.getChildren().addAll(menuBar, titleBox, titleAndText, passagesAndConfirm, playerStatistics, storyBox);


        scene = new Scene(pane, 840, 600);

    }
}
