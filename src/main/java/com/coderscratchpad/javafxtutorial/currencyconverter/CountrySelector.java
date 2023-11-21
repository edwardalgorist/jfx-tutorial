package com.coderscratchpad.javafxtutorial.currencyconverter;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/building-a-real-time-currency-converter-in-javafx/">coderscratchpad.com</a>
 */
public class CountrySelector extends ComboBox<CountrySelector.Country> {

    public CountrySelector() {
        this(false);
    }

    public CountrySelector(boolean showCurrencies) {
        initialize(showCurrencies);
    }

    /**
     * Sets the display mode of the CountrySelector.
     *
     * @param showCurrencies True to display currencies, false to display country names.
     */
    public void setShowCurrencies(boolean showCurrencies) {
        setupCellFactory(showCurrencies ? Country::getCurrency : Country::getName);
    }

    /**
     * Initializes the CountrySelector with the specified display mode.
     *
     * @param showCurrencies True to display currencies, false to display country names.
     */
    private void initialize(boolean showCurrencies) {

        final List<Country> countries = List.of(
                new Country("Zambia", "Zambian Kwacha", "ZMW",  "/flags/zm.png"),
                new Country("United States", "United States Dollar", "USD", "/flags/us.png")
        );

        // Countries to the ComboBox
        getItems().addAll(countries);

        // Select the first country
        selectionModelProperty().get().selectFirst();

        setShowCurrencies(showCurrencies);

    }

    private void setupCellFactory(Function<Country, String> propertyExtractor) {
        setCellFactory(param -> new CustomListCell(propertyExtractor));
        setButtonCell(new CustomListCell(propertyExtractor));
    }

    // Create a custom ListCell for displaying the country information
    private static class CustomListCell extends ListCell<Country> {
        private final Function<Country, String> propertyExtractor;

        public CustomListCell(Function<Country, String> propertyExtractor) {
            this.propertyExtractor = propertyExtractor;
        }

        @Override
        protected void updateItem(Country item, boolean empty) {
            super.updateItem(item, empty);

            if (item != null && !empty) {
                ImageView flag = new ImageView(item.getFlag());
                flag.setFitHeight(20);
                flag.setFitWidth(20);
                setText(propertyExtractor.apply(item));
                setGraphic(flag);
            } else {
                setText(null);
                setGraphic(null);
            }
        }
    }

    public static class Country {

        private final String name;
        private final String currency;

        private final String currencyCode;

        private final Image flag;

        public Country(String name, String currency, String currencyCode, String flagPath) {
            this.name = name;
            this.currency = currency;
            this.currencyCode = currencyCode;
            this.flag = new Image(Objects.requireNonNull(getClass().getResourceAsStream(flagPath)));
        }

        public String getName() {
            return name;
        }

        public String getCurrency() {
            return currency;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public Image getFlag() {
            return flag;
        }
    }

}