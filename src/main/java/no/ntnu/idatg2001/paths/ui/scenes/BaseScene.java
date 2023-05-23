package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.application.Platform;
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
        closeItem.setOnAction(e -> Platform.exit());

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