package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.application.Platform;
import no.ntnu.idatg2001.paths.base.Game;
import no.ntnu.idatg2001.paths.Player.Player;
import no.ntnu.idatg2001.paths.ui.dialogs.HelpDialog;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;
import no.ntnu.idatg2001.paths.utility.FileReader;

public abstract class BaseController {

    protected SceneManager sceneManager;
    protected FileReader fileHandler;
    protected Game game;
    protected  Player player;

    public BaseController(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.game = sceneManager.getGame();
        this.fileHandler = new FileReader();
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



    public void onMenuBarHelp() {
        String infoText = """
                Paths is an application that lets you play a non-linear text based story game!
                To start a game you need to edit player, edit goals and load a story.
                Once you have done this you may click start game and begin to play.
                When Playing you will see the story title at the top.
                The current passage title and its content is displayed a little to the further down and to the left.
                To the right of this you can see the links that are tied to the current passage.
                Select a link and press the confirm button to decide what to do next in the story.
                At the bottom of the GameScene you can see information about the player and the goals that are setfor the current game.""";
        HelpDialog helpDialog = new HelpDialog(infoText);
        helpDialog.showAndWait();
    }

    public void onMenuBarExit() {
        Platform.exit();
    }


}

