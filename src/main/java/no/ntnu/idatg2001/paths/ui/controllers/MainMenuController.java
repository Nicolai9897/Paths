package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.Game;
import no.ntnu.idatg2001.paths.Player;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;
import no.ntnu.idatg2001.paths.ui.dialogs.EditPlayerDialog;
import no.ntnu.idatg2001.paths.utility.FileHandler;

import java.io.File;

public class MainMenuController extends BaseController {


    public MainMenuController(SceneManager sceneManager) {
        super(sceneManager);
    }

    public void onStartGame() {
        if (game.getPlayer() == null /*|| game.getStory() == null || game.getGoals() == null*/) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Game Start Error");
            alert.setHeaderText(null);
            alert.setContentText("Player, Story, and/or Goals is missing. Please ensure all elements are set before starting the game.");
            alert.showAndWait();
        } else {
            sceneManager.showGameScene();
        }
    }

    public void onEditPlayer() {
        sceneManager.showEditPlayerScene();
    }

    public void onEditGoals() {
        sceneManager.showEditGoalScene();
    }

    public void onLoadStoryButton() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Story File");
        File file = fileChooser.showOpenDialog(sceneManager.getStage());
        if (file != null && file.getName().contains(".paths")) {
            System.out.println(file.getName() + "\n" + file.getPath());

        }
    }

}
