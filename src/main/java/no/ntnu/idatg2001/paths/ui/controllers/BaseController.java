package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.application.Platform;
import no.ntnu.idatg2001.paths.Game;
import no.ntnu.idatg2001.paths.Goals.Goal;
import no.ntnu.idatg2001.paths.Player;
import no.ntnu.idatg2001.paths.base.Story;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

import java.util.List;

public abstract class BaseController {

    protected SceneManager sceneManager;
    protected Game game;
    protected  Player player;

    public BaseController(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.game = new Game();
    }

    public void receivePlayerDetails(Player player) {
        game.setPlayer(player);
    }

    public Game getGame() {
        return game;
    }
    public Player getPlayer() {
        return player;
    }



    public void onMenuBarHome() {
        sceneManager.showMainMenuScene();
    }

    public void onMenuBarExit() {
        Platform.exit();
    }


}

