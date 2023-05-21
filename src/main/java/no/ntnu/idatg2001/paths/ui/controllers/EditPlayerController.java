package no.ntnu.idatg2001.paths.ui.controllers;

import no.ntnu.idatg2001.paths.ui.dialogs.EditPlayerDialog;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

public class EditPlayerController extends BaseController{
    public EditPlayerController(SceneManager sceneManager) {
        super(sceneManager);
    }

    public void onEditPlayer(){
        EditPlayerDialog playerDialog = new EditPlayerDialog();
        playerDialog.showDialog();
    }

    public void onBack(){
        sceneManager.showMainMenuScene();
    }
}
