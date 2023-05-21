package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        Label label = new Label("start game scene");
        Button backButton = new Button("Back");
        VBox centerNode = new VBox(10, label, backButton);
        centerNode.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane();
        pane.setTop(menuBar(gameController));
        pane.setCenter(centerNode);

        backButton.setOnAction(e -> gameController.onBackButton());

        scene = new Scene(pane, 840, 600);

    }
}
