package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.BaseController;

public abstract class BaseScene {

    protected Scene scene;
    protected Stage stage;
    protected SceneManager sceneManager;

    public BaseScene(SceneManager sceneManager, Stage stage) {
        this.sceneManager = sceneManager;
        this.stage = stage;
        setupScene();
    }

    protected abstract void setupScene();

    public Scene getScene() {
        return this.scene;
    }

    /**
     * menuBar method creates the menubar for the application window. Returns the menubar so this can be implemented easily in every scene.
     * @return The menubar
     */
    public Node menuBar(BaseController controller){
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);

        MenuItem home = new Menu("Home");
        MenuItem closeItem = new MenuItem("Close");
        fileMenu.getItems().addAll(home, closeItem);
        home.setOnAction(e -> controller.menuBarHome());
        closeItem.setOnAction(e -> controller.menuBarExit());

        return menuBar;
    }
}