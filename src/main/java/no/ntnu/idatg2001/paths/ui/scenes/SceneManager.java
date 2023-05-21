package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.EditGoalsController;
import no.ntnu.idatg2001.paths.ui.controllers.EditPlayerController;
import no.ntnu.idatg2001.paths.ui.controllers.GameController;
import no.ntnu.idatg2001.paths.ui.controllers.MainMenuController;


public class SceneManager {
    private Stage stage;

    //Controllers
    private MainMenuController mainMenuController;
    private GameController gameController;
    private EditGoalsController editGoalsController;
    private EditPlayerController editPlayerController;

    //Scenes
    private MainMenuScene mainMenuScene;
    private GameScene gameScene;
    private EditGoalsScene editGoalsScene;
    private EditPlayerScene editPlayerScene;

    public SceneManager(Stage stage){
        this.stage = stage;

        //controllers
        this.mainMenuController = new MainMenuController(this);
        this.gameController = new GameController(this);
        this.editGoalsController = new EditGoalsController(this);
        this.editPlayerController = new EditPlayerController(this);

        //scenes
        mainMenuScene = new MainMenuScene(this, stage, mainMenuController);
        gameScene = new GameScene(this, stage, gameController);
        editGoalsScene = new EditGoalsScene(this, stage, editGoalsController);
        editPlayerScene = new EditPlayerScene(this, stage, editPlayerController);
    }

    public void showMainMenuScene() {
        stage.setScene(mainMenuScene.getScene());
        mainMenuScene.getScene().getRoot().requestFocus();

    }

    public void showGameScene() {
        stage.setScene(gameScene.getScene());
        gameScene.getScene().getRoot().requestFocus();
    }

    public void showEditPlayerScene(){
        stage.setScene(editPlayerScene.getScene());
    }

    public void showEditGoalScene() {
        stage.setScene(editGoalsScene.getScene());
        editGoalsScene.getScene().getRoot().requestFocus();
    }

    public Stage getStage() {
        return this.stage;
    }


}
