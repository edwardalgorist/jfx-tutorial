package com.coderscratchpad.javafxtutorial.htmleditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-htmleditor-rich-text-editing/">coderscratchpad.com</a>
 */
public class HTMLEditorSettingHTMLContent extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX HTMLEditor: Rich Text Editing");

        // Create the HTMLEditor
        HTMLEditor htmlEditor = new HTMLEditor();

        // Add the HTMLEditor to the BorderPane
        this.parent.setCenter(htmlEditor);

        // Setting HTML text
        String newHtmlContent = "<p>This is a <strong>bold</strong> example.</p>";
        htmlEditor.setHtmlText(newHtmlContent);

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}