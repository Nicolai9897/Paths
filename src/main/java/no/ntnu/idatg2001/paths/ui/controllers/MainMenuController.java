package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;
import no.ntnu.idatg2001.paths.ui.dialogs.EditPlayerDialog;
import java.io.File;

public class MainMenuController extends BaseController {

    public MainMenuController(SceneManager sceneManager) {
        super(sceneManager);
    }

    public void onStartGame() {
        sceneManager.showGameScene();
    }

    public void onEditPlayer() {
        EditPlayerDialog playerDialog = new EditPlayerDialog();
        playerDialog.showDialog();
    }

    public void onEditGoals() {

    }

    public void onLoadStoryButton() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Story File");
        File file = fileChooser.showOpenDialog(sceneManager.getStage());
        if (file != null) {
            // Load the story from the file. Should also check that it is a .paths file

        }
    }

}
