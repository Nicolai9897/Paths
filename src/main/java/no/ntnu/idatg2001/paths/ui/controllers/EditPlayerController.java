package no.ntnu.idatg2001.paths.ui.controllers;

import no.ntnu.idatg2001.paths.Player.Player;
import no.ntnu.idatg2001.paths.ui.dialogs.EditPlayerDialog;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;
import java.util.Optional;

public class EditPlayerController extends BaseController{

    public EditPlayerController(SceneManager sceneManager) {
        super(sceneManager);
    }

    public void onEditPlayer(){
        EditPlayerDialog playerDialog = new EditPlayerDialog(this);
        Optional<Player> result = playerDialog.showDialog();
        if(result.isPresent()) {
            Player player = result.get();
            sceneManager.updatePlayerInEditScene(player);
        }
    }


    public void onBack(){
        sceneManager.showMainMenuScene();
    }
}
