package com.coderscratchpad.javafxtutorial.webview;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-webview/">coderscratchpad.com</a>
 */
public class WebViewJavaScriptInteraction extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        WebView webView = new WebView();
        webView.getEngine().loadContent("<html>" +
                "<body>" +
                "<h1 id='header'>Hello from JavaScript!</h1>" +
                "</body>" +
                "</html>");

        webView.getEngine().getLoadWorker().stateProperty().addListener((ov, oldState, newState) -> {

            if (newState == Worker.State.SUCCEEDED) {

                String headerText = (String) webView.getEngine().executeScript("document.getElementById('header').innerText");

                System.out.println("Header Text: " + headerText);

            }

        });

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