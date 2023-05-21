package no.ntnu.idatg2001.paths.ui.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.scenes.SceneManager;

public class EditGoalsController {

        private Stage stage;
        private SceneManager scene;

        public EditGoalsController(Stage stage, SceneManager scene){
            this.stage = stage;
            this.scene = scene;
        }

        public void onEditGoal() {
            Scene editGoalScene = scene.editGoalScene();
            this.stage.setScene(editGoalScene);
        }
}
