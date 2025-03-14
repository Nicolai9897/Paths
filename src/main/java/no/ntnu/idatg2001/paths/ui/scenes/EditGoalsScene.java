package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.EditGoalsController;

/**
 * EditGoalsScene
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class EditGoalsScene extends  BaseScene{

    private final EditGoalsController editGoalsController;

    public EditGoalsScene(SceneManager sceneManager, Stage stage, EditGoalsController controller) {
        super(sceneManager, stage, controller);
        this.editGoalsController = controller;
    }

    @Override
    protected void setupScene() {
        //UI controls design
        //Left controls
        Label goalType = new Label("Goal type: ");
        Label goalValue = new Label("Goal value: ");
        ComboBox<String> goalTypesComboBox = new ComboBox<>();
        goalTypesComboBox.getItems().addAll("GoldGoal", "HealthGoal", "InventoryGoal", "ScoreGoal");
        Tooltip tooltip = new Tooltip("Select Goal type");
        goalTypesComboBox.setTooltip(tooltip);

        TextField goalValueField = new TextField();
        Button addGoalButton = new Button("Add Goal");

        //center controls
        Label title = new Label("Edit Goals");
        title.setFont(new Font(72));
        Label infoLabel = new Label("It is recommended that blablbalab\n because this and that and blabalbal");

        Label goalsLabel = new Label("Goals:");
        ListView<String> goalList = new ListView<>();

        //container setup
        //Left container
        GridPane grid = new GridPane();
        grid.add(goalType,0, 0);
        grid.add(goalTypesComboBox, 1, 0);
        grid.add(goalValue,0 ,2);
        grid.add(goalValueField, 1, 2);
        grid.setVgap(5);
        VBox goalControls = new VBox(10, grid, addGoalButton);
        goalControls.setAlignment(Pos.CENTER);
        goalControls.setPadding(new Insets(10));

        //Center Container
        VBox titleVBox = new VBox(title);
        VBox infoVBox = new VBox(infoLabel);
        titleVBox.setAlignment(Pos.TOP_CENTER);
        titleVBox.setPadding(new Insets(10));
        infoVBox.setAlignment(Pos.CENTER);

        StackPane center = new StackPane();
        center.setAlignment(Pos.TOP_CENTER);
        center.getChildren().addAll(titleVBox, infoVBox);

        //Right container
        goalList.setPrefSize(200,200);
        goalList.setStyle("-fx-border-color:black;");
        VBox goalListNode = new VBox(10, goalsLabel, goalList);
        goalListNode.setPadding(new Insets(10));
        goalListNode.setAlignment(Pos.CENTER);

        //Bottom container
        Button backButton = new Button("Back");
        VBox bottomNode = new VBox(backButton);
        bottomNode.setPadding(new Insets(25));

        //Pane setup
        BorderPane pane = new BorderPane();
        pane.setTop(menuBar);
        pane.setLeft(goalControls);
        pane.setCenter(center);
        pane.setRight(goalListNode);
        pane.setBottom(bottomNode);

        //Button functionality
        backButton.setOnAction(e -> editGoalsController.onBackButton());

        scene = new Scene(pane, 840, 600);
    }

}
