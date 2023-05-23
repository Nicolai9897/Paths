package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.application.Platform;
import no.ntnu.idatg2001.paths.base.Game;
import no.ntnu.idatg2001.paths.player.Player;
import no.ntnu.idatg2001.paths.ui.dialogs.HelpDialog;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;
import no.ntnu.idatg2001.paths.utility.FileReader;

/**
 * BaseController is abstract class that serves as a super class for the other controllers. It contains
 * references to commonly used objects.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public abstract class BaseController {

    protected SceneManager sceneManager;
    protected FileReader fileHandler;
    protected Game game;
    protected  Player player;

    /**
     * Constructs a BaseController with a given SceneManager.
     * initializes a Game and FileReader.
     *
     * @param sceneManager
     */
    public BaseController(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.game = sceneManager.getGame();
        this.fileHandler = new FileReader();
    }

    /**
     * Receives the Player instance and sets it in the current Game.
     * @param player
     */
    public void receivePlayerDetails(Player player) {
        game.setPlayer(player);
    }

    /**
     * Gets the Game.
     * @return
     */
    public Game getGame() {
        return game;
    }

    /**
     * Gets the Player.
     * @return
     */
    public Player getPlayer() {
        return player;
    }


    /**
     * Handles action for when the help item is clicked in the menubar.
     * Displays the dialog and defines and passes the text that is to be shown in the dialog.
     */
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

    /**
     * Handles the action for when the exit item is clicked in the menubar.
     * Exits the application.
     */
    public void onMenuBarExit() {
        Platform.exit();
    }


}

