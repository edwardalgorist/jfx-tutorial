package com.coderscratchpad.javafxtutorial;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/customizing-javafx-stage-icons-for-your-applications/">coderscratchpad.com</a>
 */
public class SettingStageIcon extends Application {

    private static final double WIDTH  = 640;
    private static final double HEIGHT = 480;

    @Override
    public void start(Stage stage) {

        BorderPane layoutManager = new BorderPane();
        Scene scene = new Scene(layoutManager, WIDTH, HEIGHT);

        Image icon = new Image("duck.png");

        /* set stage icon */
        stage.getIcons().add(icon);

        stage.setTitle("Adding an Icon to Your JavaFX Stage");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }
}
