package no.ntnu.idatg2001.paths.ui.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import no.ntnu.idatg2001.paths.ui.controllers.EditGoalsController;
import no.ntnu.idatg2001.paths.ui.controllers.MainMenuController;
import no.ntnu.idatg2001.paths.ui.controllers.MenuBarController;


public class SceneManager {
    private MainMenuController mainMenuController;
    private EditGoalsController goalsController;
    private MenuBarController menuBarcontroller;

    public SceneManager(MainMenuController mainMenuController, EditGoalsController goalsController){
        this.mainMenuController = mainMenuController;
        this.goalsController = goalsController;
    }


    public Scene mainMenu(MainMenuController controller){


        //UI controls design
        Button startButton = new Button("Start Game");
        startButton.setPrefSize(200,100);
        startButton.setFont(new Font(20));
        Button editPlayerButton = new Button("Edit player");
        Button editGoalsButton = new Button("Edit goals");
        Button loadStoryButton = new Button("Load Story");
        Label pathsLabel = new Label("Paths");
        pathsLabel.setFont(Font.font("Comic Sans MS", 72));
        Label storyTitleLabel = new Label("story title example");
        storyTitleLabel.setFont(Font.font("Comic Sans MS", 16));
        ListView<String> passageList = new ListView<>();
        passageList.setPrefSize(30,200);
        passageList.setStyle("-fx-border-color:black;");

        //Container setup
        VBox controlButtons = new VBox(10, startButton, editPlayerButton, editGoalsButton, loadStoryButton);
        VBox centerNode = new VBox(50, pathsLabel, controlButtons);
        VBox rightNode = new VBox(10, storyTitleLabel, passageList);
        rightNode.setPadding(new Insets(10));
        controlButtons.setAlignment(Pos.CENTER);
        centerNode.setAlignment(Pos.CENTER);
        rightNode.setAlignment(Pos.CENTER);

        //Pane setup
        BorderPane pane = new BorderPane();
        pane.setTop(menuBar(new MenuBarController(new Stage(), new SceneManager(mainMenuController,goalsController))));
        pane.setCenter(centerNode);
        pane.setRight(rightNode);

        //button functionality
        startButton.setOnAction(e -> controller.onStartGame());
        loadStoryButton.setOnAction(e -> controller.onLoadStoryButton());
        editPlayerButton.setOnAction(e -> controller.onEditPlayer());
        editGoalsButton.setOnAction(e -> controller.onEditGoals());

        Scene mainMenuScene = new Scene(pane, 840, 600);

        return mainMenuScene;
    }

    public Scene startGameScene() {

        Label centerNode = new Label("start game scene");
        BorderPane pane = new BorderPane();
        pane.setTop(menuBar(new MenuBarController(new Stage(), new SceneManager(mainMenuController,goalsController))));
        pane.setCenter(centerNode);

        Scene startGameScene = new Scene(pane, 840, 600);

        return startGameScene;
    }

    public Scene editGoalScene() {

        Label centerNode = new Label("edit goal scene");
        BorderPane pane = new BorderPane();
        pane.setTop(menuBar(new MenuBarController(new Stage(), new SceneManager(mainMenuController,goalsController))));
        pane.setCenter(centerNode);
        Scene editGoalScene = new Scene(pane, 840, 600);

        return editGoalScene;
    }


    /**
     * menuBar method creates the menubar for the application window. Returns the menubar so this can be implemented easily in every scene.
     * @return The menubar
     */
    public Node menuBar(MenuBarController controller){
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);

        MenuItem home = new Menu("Home");
        MenuItem closeItem = new MenuItem("Close");
        fileMenu.getItems().addAll(home, closeItem);
        home.setOnAction(e -> controller.onHome());
        closeItem.setOnAction(e -> controller.onExit());

        return menuBar;
    }
}
