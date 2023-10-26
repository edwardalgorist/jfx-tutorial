module com.coderscratchpad.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;
    requires com.google.zxing;
    requires javafx.swing;
    requires javafx.web;
    requires java.prefs;

    exports com.coderscratchpad.javafxtutorial;
    exports com.coderscratchpad.javafxtutorial.button;
    exports com.coderscratchpad.javafxtutorial.datepicker;

    opens com.coderscratchpad.javafxtutorial to javafx.fxml;
    opens com.coderscratchpad.javafxtutorial.button to javafx.fxml;
    opens com.coderscratchpad.javafxtutorial.datepicker to javafx.fxml;
}