package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;
import java.io.File;

/**
 * Controller for the MainMenuScene. Handles the actions for when something happens in the scene.
 * Inherits from the Super Class BaseController.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class MainMenuController extends BaseController {

    /**
     * Constructor for the MainMenuController.
     * @param sceneManager
     */
    public MainMenuController(SceneManager sceneManager) {
        super(sceneManager);
    }

    /**
     * Handles action for when the star game button is pressed.
     * Checks if the user has set values for player, story and goals. If one or more of these are undefined,
     * returns an alert with information to the user.
     * If the user has defined the required values, the GameScene is displayed through the sceneManager.
     */
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

    /**
     * Handles the action for when the editPlayer button is pressed.
     * Changes scene to EditPlayerScene.
     */
    public void onEditPlayer() {
        sceneManager.showEditPlayerScene();
    }

    /**
     * Handles the action for when the editGoals button is pressed.
     * Changes scene to EditGoals
     */
    public void onEditGoals() {
        sceneManager.showEditGoalScene();
    }

    /**
     * Handles action for when the loadStory button is pressed.
     * Checks if a file is selected and if it contains .paths to check if the format is correct.
     */
    public void onLoadStoryButton() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Story File");
        File file = fileChooser.showOpenDialog(sceneManager.getStage());
        if (file != null && file.getName().contains(".paths")) {
            System.out.println(file.getName() + "\n" + file.getPath());

        }
    }

}
