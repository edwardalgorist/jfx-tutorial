package com.coderscratchpad.javafxtutorial.textarea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-textarea-multi-line-text-input/">coderscratchpad.com</a>
 */
public class TextAreaWordWrap extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        // Create the TextArea
        TextArea textArea = new TextArea();

        // Set initial text
        textArea.setText("Pellentesque habitant morbi tristique senectus et netus et malesuada " +
                "fames ac turpis egestas. Ut nec risus nec turpis facilisis vulputate. Aliquam erat " +
                "volutpat. Curabitur a est eros. Vivamus sit amet consectetur arcu. Duis id rhoncus " +
                "neque. In sit amet ligula sed diam auctor accumsan. Quisque gravida ullamcorper " +
                "ultricies. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per " +
                "inceptos himenaeos. Donec condimentum mi vel tortor varius laoreet. Nullam nunc purus, " +
                "pharetra at est sed, egestas auctor nunc. Sed faucibus, nulla sed sollicitudin pulvinar, " +
                "magna erat placerat mauris, vel hendrerit erat ex eu velit. Vestibulum ante ipsum primis " +
                "in faucibus orci luctus et ultrices posuere cubilia curae; Nullam at feugiat metus.");

        // Enable text wrapping
        textArea.setWrapText(true);

        // Add the TextArea to the BorderPane
        this.parent.setCenter(textArea);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX TextArea: Multi-Line Text Input");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}