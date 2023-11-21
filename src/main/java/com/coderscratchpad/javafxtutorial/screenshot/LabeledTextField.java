package com.coderscratchpad.javafxtutorial.screenshot;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.Builder;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/capturing-screenshots-with-javafx/">coderscratchpad.com</a>
 */
// Custom class to create labeled text fields
public class LabeledTextField implements Builder<HBox> {

    private final HBox hBox;

    public LabeledTextField(double spacing, String label, TextField textField) {
        hBox = new HBox(spacing, new Label(label), textField);
        hBox.setAlignment(Pos.CENTER);
    }

    @Override
    public HBox build() {
        return this.hBox;
    }
}
