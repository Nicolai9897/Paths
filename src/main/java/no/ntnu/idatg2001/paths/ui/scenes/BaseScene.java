package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.BaseController;

/**
 * BaseScene is abstract class that serves as a super class for the other scenes. It contains
 * references to commonly used objects. Scenes takes care of the javafx code for the design of the different
 * views.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 *
 *
 */
public abstract class BaseScene {

    protected Scene scene;
    protected Stage stage;
    protected SceneManager sceneManager;
    protected BaseController controller;
    protected MenuBar menuBar;

    public BaseScene(SceneManager sceneManager, Stage stage, BaseController controller) {
        this.sceneManager = sceneManager;
        this.controller = controller;
        this.stage = stage;
        this.menuBar = createMenuBar();
        setupScene();
    }

    protected abstract void setupScene();

    protected  MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);
        MenuItem closeItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(closeItem);
        closeItem.setOnAction(e -> controller.onMenuBarExit());

        Menu aboutMenu = new Menu("About");
        menuBar.getMenus().add(aboutMenu);
        MenuItem help = new MenuItem("Help");
        aboutMenu.getItems().addAll(help);
        help.setOnAction(e -> controller.onMenuBarHelp());

        return menuBar;
    }

    public Scene getScene() {
        return this.scene;
    }

}