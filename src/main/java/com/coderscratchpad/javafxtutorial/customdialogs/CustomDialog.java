package com.coderscratchpad.javafxtutorial.customdialogs;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/building-javafx-custom-dialogs/">coderscratchpad.com</a>
 */
public class CustomDialog extends Dialog<String> {

    private final ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);

    private final ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

    public CustomDialog() {

        setTitle("Custom Dialog");

        // Set the content of the dialog
        StackPane contentPane = new StackPane();

        contentPane.setPrefSize(300, 200);

        Label label = new Label("Coder Scratchpad v1");
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 17px;");

        Text text = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "In in sapien non nisl maximus maximus. " +
                "Fusce a leo egestas, dignissim urna ut, ullamcorper ante. " +
                "Nulla auctor felis turpis, eget molestie nisl sollicitudin vitae. " +
                "Nulla tincidunt vel sem vel fringilla. " +
                "Donec nisl diam, porta vitae sem nec, lacinia volutpat nulla. " +
                "Aenean tristique placerat nisi, a sollicitudin ligula finibus ac. " +
                "Aliquam egestas consectetur sapien, quis varius libero gravida at. " +
                "Sed faucibus eu augue a ornare.");

        text.wrappingWidthProperty().set(300);

        VBox vBox = new VBox(15, label,text);

        contentPane.getChildren().addAll(vBox);

        getDialogPane().setContent(contentPane);

        // Add buttons to the dialog
        getDialogPane().getButtonTypes().addAll(saveButtonType, cancelButtonType);

        // Set the result converter
        setResultConverter(buttonType -> {

            if (buttonType == saveButtonType) {

                // Perform actions when the "Save" button is clicked
                return "Save";

            } else {

                // Perform actions when the "Cancel" button is clicked or the dialog is closed
                return null;

            }

        });

    }

}