package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.application.Platform;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.base.Game;
import no.ntnu.idatg2001.paths.player.Player;
import no.ntnu.idatg2001.paths.ui.controllers.*;


public class SceneManager {
    private final Stage stage;
    private final Game game;

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
        Platform.runLater(() -> {
            mainMenuScene.getFocusButton().requestFocus();
        });
    }

    public void showGameScene() {
        stage.setScene(gameScene.getScene());
        Platform.runLater(() -> {
            gameScene.getFocusButton().requestFocus();
        });
    }

    public void showEditPlayerScene(){
        stage.setScene(editPlayerScene.getScene());
    }

    public void showEditGoalScene() {
        stage.setScene(editGoalsScene.getScene());
        editGoalsScene.getScene().getRoot().requestFocus();
    }


    public void showGameOver() {
        gameOverScene.setMessage(gameOverController.checkGameEndCondition());
        gameOverScene.menuBar.requestFocus();
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
