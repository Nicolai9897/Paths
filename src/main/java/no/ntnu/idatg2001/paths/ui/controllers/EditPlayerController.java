package no.ntnu.idatg2001.paths.ui.controllers;

import no.ntnu.idatg2001.paths.player.Player;
import no.ntnu.idatg2001.paths.ui.dialogs.EditPlayerDialog;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;
import java.util.Optional;

/**
 * Controller for the EditPlayerScene. Handles the actions for when something happens in the scene.
 * Inherits from the Super Class BaseController.
 */
public class EditPlayerController extends BaseController{

    /**
     * Contructor for the controller.
     * @param sceneManager
     */
    public EditPlayerController(SceneManager sceneManager) {
        super(sceneManager);
    }

    /**
     * Handles the action for when the editPlayer Button is pressed.
     * Opens the EditPlayerDialog and receives the user input for the player info,
     * and updates the corresponding labels in the respective scene.
     */
    public void onEditPlayer(){
        EditPlayerDialog playerDialog = new EditPlayerDialog(this);
        Optional<Player> result = playerDialog.showDialog();
        if(result.isPresent()) {
            Player player = result.get();
            sceneManager.updatePlayerInEditScene(player);
        }
    }

    /**
     * Handles action for when the back button is pressed.
     * Shows the MainMenuScene through the sceneManager.
     */
    public void onBack(){
        sceneManager.showMainMenuScene();
    }
}
