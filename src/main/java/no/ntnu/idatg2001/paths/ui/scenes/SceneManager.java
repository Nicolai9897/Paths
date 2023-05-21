package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.EditGoalsController;
import no.ntnu.idatg2001.paths.ui.controllers.GameController;
import no.ntnu.idatg2001.paths.ui.controllers.MainMenuController;


public class SceneManager {
    private Stage stage;
    private MainMenuController mainMenuController;
    private GameController gameController;
    private EditGoalsController editGoalsController;

    public SceneManager(Stage stage){
        this.stage = stage;
        this.mainMenuController = new MainMenuController(this);
        this.gameController = new GameController(this);
        //this.editGoalsController = new EditGoalsController(this);
    }

    public void showMainMenuScene() {
        MainMenuScene mainMenuScene = new MainMenuScene(this, stage, mainMenuController);
        stage.setScene(mainMenuScene.getScene());
    }



    public void showGameScene() {
        GameScene gameScene = new GameScene(this, stage, gameController);
        stage.setScene(gameScene.getScene());
    }

    public void showEditGoalScene() {

    }

    public Stage getStage() {
        return this.stage;
    }

}
