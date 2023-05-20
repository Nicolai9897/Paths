package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.Scenes;
import no.ntnu.idatg2001.paths.ui.dialogs.EditPlayerDialog;
import java.io.File;

public class MainMenuController {
    private Stage stage;
    private Scenes scene;

    public MainMenuController(Stage stage, Scenes scene){
        this.stage = stage;
        this.scene = scene;
    }

    public void onStartGame() {
        System.out.println("scene change wohoo");
        Scene startGameScene = scene.startGameScene();
        this.stage.setScene(startGameScene);
    }

    public void onEditPlayer() {
        EditPlayerDialog playerDialog = new EditPlayerDialog();
        playerDialog.showDialog();
    }

    public void onLoadStoryButton() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Story File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            // Load the story from the file. Should also check that it is a .paths file

        }
    }

}
