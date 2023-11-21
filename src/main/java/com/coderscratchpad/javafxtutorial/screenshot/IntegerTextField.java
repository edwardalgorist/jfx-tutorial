package com.coderscratchpad.javafxtutorial.screenshot;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/capturing-screenshots-with-javafx/">coderscratchpad.com</a>
 */
// Custom class for IntegerTextFields with input validation
public class IntegerTextField extends TextField {

    public IntegerTextField() {
        super();

        this.setMaxWidth(50.0);

        this.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 1, change -> {

            // Allow only integer values
            if (change.getControlNewText().matches("\\d+")) {
                return change;
            }

            return null;

        }));
    }

    public int getInteger() {
        return Integer.parseInt(this.getText());
    }
}
