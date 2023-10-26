package com.coderscratchpad.javafxtutorial.webview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-webview/">coderscratchpad.com</a>
 */
public class WebViewHTMLFile extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        WebView webView = new WebView();

        String url = this.getClass().getClassLoader().getResource("example.html").toExternalForm();

        webView.getEngine().load(url);

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