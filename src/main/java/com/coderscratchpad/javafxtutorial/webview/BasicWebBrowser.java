package com.coderscratchpad.javafxtutorial.webview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-webview/">coderscratchpad.com</a>
 */
public class BasicWebBrowser extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    private WebView webView;

    @Override
    public void start(Stage stage) throws Exception {

        TextField textField = new TextField();
        textField.setPromptText("Type a URL");

        textField.setOnKeyReleased(keyEvent -> {

            if(keyEvent.getCode() == KeyCode.ENTER) {

                try {

                    this.webView.getEngine().load(textField.getText());

                } catch(IllegalArgumentException exception) { exception.printStackTrace(); }

            }

        });

        this.webView = new WebView();

        // Loads Google by default
        this.webView.getEngine().load("https://www.google.com");

        this.parent.setTop(textField);

        this.parent.setCenter(webView);

        this.setupStage(stage);

    }

    private void setupStage(Stage stage) throws IOException {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("JavaFX WebView");

        // Sets the stage scene
        stage.setScene(scene);

        // Centers stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

}
