package com.coderscratchpad.javafxtutorial.radiobutton;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/how-to-create-radiobuttons-in-javafx/">coderscratchpad.com</a>
 */
public class OptionSelector extends VBox {

    public OptionSelector(String[] options, String defaultOption, String label) {

        // Add 5px spacing between nodes
        super(10);

        // Add a prompt Label to the options selector
        this.getChildren().addAll(new VBox(new Label(label)));

        // Create a ToggleGroup for the RadioButtons
        ToggleGroup group = new ToggleGroup();

        // Create a container to house the option buttons,
        // Add 3px spacing between buttons
        VBox optionsContainer = new VBox(3);

        for (String option : options) {

            // Create RadioButton
            RadioButton optionButton = new RadioButton(option);

            // Set the ToggleGroup
            optionButton.setToggleGroup(group);

            // Set the default selected option
            if (option.equalsIgnoreCase(defaultOption))
                group.selectToggle(optionButton);

            // Add option button to the options container
            optionsContainer.getChildren().addAll(optionButton);

        }

        // Create a submit button
        Button submit = new Button("Submit");

        // Add submit button action handler
        submit.setOnAction(actionEvent -> {

            // Get selected option button
            RadioButton optionButton = (RadioButton) group.getSelectedToggle();

            // Get and print the text on the button
            System.out.println("The selected option is " + optionButton.getText());

        });

        // Add the options container to the options selector
        this.getChildren().addAll(optionsContainer);

        // Add submit button to the options selector
        this.getChildren().addAll(new VBox(submit));

    }

}
