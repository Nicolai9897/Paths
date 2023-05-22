package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.EditPlayerController;

public class EditPlayerScene extends  BaseScene {

    private final EditPlayerController editPlayerController;

    public EditPlayerScene(SceneManager sceneManager, Stage stage, EditPlayerController controller) {
        super(sceneManager, stage);
        this.editPlayerController = controller;
    }

    @Override
    protected void setupScene() {

        Label title = new Label("Edit Player");
        title.setFont(new Font(72));
        //title.setPadding(new Insets(10, 0, 50, 0));
        title.setAlignment(Pos.TOP_CENTER);

        Label nameLabel = new Label("Player Name");
        Label playerNameLabel = new Label("here goeth name");
        VBox nameVBox = new VBox(5, nameLabel, playerNameLabel);
        nameVBox.setAlignment(Pos.CENTER);

        Label healthLabel = new Label("Player starting health");
        Label playerHealthLabel = new Label("health goeth here");
        VBox healthVBox = new VBox(5, healthLabel, playerHealthLabel);
        healthVBox.setAlignment(Pos.CENTER);

        Label goldLabel = new Label("Player starting gold");
        Label playerGold = new Label("gold amount goeth here");
        VBox goldVBox = new VBox(5, goldLabel, playerGold);
        goldVBox.setAlignment(Pos.CENTER);

        VBox centerNode = new VBox(50, title, nameVBox, healthVBox, goldVBox);
       centerNode.setAlignment(Pos.CENTER);

        Button backButton = new Button("Back");
        Button editPlayerButton = new Button("Edit Player");
        HBox bottomButtons = new HBox(backButton, editPlayerButton);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setSpacing(25);
        bottomButtons.setPadding(new Insets(25));

        BorderPane pane = new BorderPane();
        pane.setTop(menuBar);
        pane.setCenter(centerNode);
        pane.setBottom(bottomButtons);

        backButton.setOnAction(e -> editPlayerController.onBack());
        editPlayerButton.setOnAction(e -> editPlayerController.onEditPlayer());

        scene = new Scene(pane, 840, 600);
    }
}
