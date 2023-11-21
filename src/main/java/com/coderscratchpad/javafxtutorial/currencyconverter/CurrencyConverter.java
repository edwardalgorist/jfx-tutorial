package com.coderscratchpad.javafxtutorial.currencyconverter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.UnaryOperator;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/building-a-real-time-currency-converter-in-javafx/">coderscratchpad.com</a>
 */
public class CurrencyConverter extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    // Create country selection drop-downs
    private final CountrySelector from = new CountrySelector(true);
    private final CountrySelector to = new CountrySelector(true);

    // Create a TextField for entering the amount to convert
    private final TextField amountField = new TextField();

    // Create labels for result and exchange rate
    private final Label result = new Label("0.00 ZMW");
    private final Label rate = new Label("0 USD = 0.00 ZMW");

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Building a Real-time Currency Converter in JavaFX");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // Set styles for result and rate labels
        result.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: 'Trebuchet MS';");
        rate.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-font-family: 'Trebuchet MS';");

        // Create a NumericFormatter to restrict input to numeric values only
        NumericFormatter numericFormatter = new NumericFormatter();

        // Set an initial selection for the 'from' ComboBox
        from.selectionModelProperty().get().select(1);

        // Apply the NumericFormatter to the amountField
        amountField.setTextFormatter(numericFormatter);

        // Add listeners for changes in input, 'from' selection, and 'to' selection
        amountField.textProperty().addListener(this::updateConversion);
        from.valueProperty().addListener(this::updateConversion);
        to.valueProperty().addListener(this::updateConversion);

        // Create a container for center-aligned content
        VBox centerContainer = new VBox(
                15, amountField, from, to,
                new VBox(50), // Empty space for spacing
                new VBox(5, result, rate)
        );

        centerContainer.setAlignment(Pos.CENTER);

        // Create an empty left VBox for left alignment
        VBox leftContainer = new VBox();
        leftContainer.setAlignment(Pos.TOP_LEFT);

        // Combine the left and center containers in a horizontal layout
        HBox mainContainer = new HBox(leftContainer, centerContainer);
        mainContainer.setAlignment(Pos.CENTER);

        // Set the main container as the center content of the BorderPane
        parent.setCenter(mainContainer);
    }

    private void updateConversion(Observable observable) {

        // Start a new thread (ConverterTask) to perform currency conversion asynchronously
        Thread thread = new Thread(new ConverterTask());

        // Daemon thread to exit when the application exits
        thread.setDaemon(true);
        thread.start();
    }

    private static class NumericFormatter extends TextFormatter<Double> {

        public NumericFormatter() {

            // Initialize the NumericFormatter with appropriate settings
            this(change -> {

                String newText = change.getControlNewText();
                if (newText.matches("[0-9]*\\.?[0-9]*")) {

                    // Accept the change if it's a valid numeric input
                    return change;
                }

                // Reject the change if it's not a valid numeric input
                return null;

            });

        }

        private NumericFormatter(UnaryOperator<Change> unaryOperator) {
            super(unaryOperator);
        }

    }

    private class ConverterTask extends Task<Void> {

        @Override
        protected Void call() throws Exception {

            try {

                // Get source and target currency codes, input value
                String fromCurrency = from.getValue().getCurrencyCode();
                String toCurrency = to.getValue().getCurrencyCode();
                String value = amountField.getText();
                double amount = Double.parseDouble(value.isEmpty() ? "0.0" : value);

                // Perform currency conversion and fetch results
                double[] conversionResult = ExchangeRatesClient.convert(fromCurrency, toCurrency, amount);
                double convertedAmount = conversionResult[1];
                double exchangeRate = conversionResult[0];

                // Update UI on the JavaFX application thread
                Platform.runLater(() -> {
                    result.setText(String.format("%.2f %s", convertedAmount, toCurrency));
                    rate.setText(String.format("%d %s = %.2f %s", exchangeRate > 0 ? 1 : 0, fromCurrency, exchangeRate, toCurrency));
                });

            } catch (IOException | NumberFormatException ex) {

                // Handle errors and update UI
                Platform.runLater(() -> {
                    result.setText("Error");
                    rate.setText("");
                });
                ex.printStackTrace();
            }

            return null;
        }
    }
}