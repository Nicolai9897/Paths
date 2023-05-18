package no.ntnu.idatg2001.paths.ui;


import javafx.application.Application;
import javafx.stage.Stage;

public class PathsApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Paths project");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.exit(0);
    }

    public static void appMain(String[] args) {
        launch(args);
    }
}