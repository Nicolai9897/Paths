package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.GameOverController;

public class GameOverScene extends BaseScene{

    private GameOverController gameOverController;
    private Label endCondition;

    public GameOverScene(SceneManager sceneManager, Stage stage, GameOverController controller) {
        super(sceneManager, stage);
        this.gameOverController = controller;
    }

    @Override
    protected void setupScene() {
        endCondition = new Label("Placeholder da da da d dada");
        endCondition.setFont(new Font(72));

        VBox topCenterNode = new VBox(endCondition);
        topCenterNode.setAlignment(Pos.TOP_CENTER);


        BorderPane pane = new BorderPane();
        pane.setTop(menuBar);
        pane.setCenter(topCenterNode);

        scene = new Scene(pane, 840, 600);
    }

    public void setMessage(boolean gameWon) {
        if (gameWon) {
            endCondition.setText("Congratulations! You won!");
        } else {
            endCondition.setText("Sorry, better luck next time!");
        }
    }
}

