package com.coderscratchpad.javafxtutorial.effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-reflection-effect/">coderscratchpad.com</a>
 */
public class ReflectionEffectBottomOpacity extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("Reflection Effect: Bottom Opacity");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();

        Image image = new Image("scorpion.jpg");

        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(300);

        Reflection reflection = new Reflection();
        reflection.setFraction(0.5); // Adjust the reflection height

        // Sets the bottom opacity to 0.9 (90% opacity at the bottom)
        reflection.setBottomOpacity(0.9);

        // Apply the Reflection Effect to the ImageView
        imageView.setEffect(reflection);

        /* Add the ImageView to the BorderPane top region */
        this.parent.setTop(imageView);
        BorderPane.setAlignment(imageView, Pos.CENTER);
        BorderPane.setMargin(imageView, new Insets(15));

    }

}