package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.Game;
import no.ntnu.idatg2001.paths.Goals.Goal;
import no.ntnu.idatg2001.paths.Player;
import no.ntnu.idatg2001.paths.base.Story;
import no.ntnu.idatg2001.paths.ui.controllers.*;

import java.util.List;


public class SceneManager {
    private Stage stage;
    private Game game;

    //Controllers
    private MainMenuController mainMenuController;
    private GameController gameController;
    private EditGoalsController editGoalsController;
    private EditPlayerController editPlayerController;
    private GameOverController gameOverController;

    //Scenes
    private MainMenuScene mainMenuScene;
    private GameScene gameScene;
    private EditGoalsScene editGoalsScene;
    private EditPlayerScene editPlayerScene;
    private GameOverScene gameOverScene;




    public SceneManager(Stage stage){
        this.stage = stage;
        this.game = new Game();


        //controllers
        this.mainMenuController = new MainMenuController(this);
        this.gameController = new GameController(this);
        this.editGoalsController = new EditGoalsController(this);
        this.editPlayerController = new EditPlayerController(this);
        this.gameOverController = new GameOverController(this);

        //scenes
        mainMenuScene = new MainMenuScene(this, stage, mainMenuController);
        gameScene = new GameScene(this, stage, gameController);
        editGoalsScene = new EditGoalsScene(this, stage, editGoalsController);
        editPlayerScene = new EditPlayerScene(this, stage, editPlayerController);
        gameOverScene = new GameOverScene(this, stage, gameOverController);
    }

    public void showMainMenuScene() {
        stage.setScene(mainMenuScene.getScene());

    }

    public void showGameScene() {
        stage.setScene(gameScene.getScene());
    }

    public void showEditPlayerScene(){
        stage.setScene(editPlayerScene.getScene());
    }

    public void showEditGoalScene() {
        stage.setScene(editGoalsScene.getScene());
    }


    public void showGameOver() {
        gameOverScene.setMessage(gameOverController.checkGameEndCondition());
    }

    public void updatePlayerInEditScene(Player player) {
        editPlayerScene.updatePlayerInfo(player);
        gameScene.updateLabels(player);
    }

    public Game getGame() {
        return game;
    }

    public Stage getStage() {
        return this.stage;
    }


}
