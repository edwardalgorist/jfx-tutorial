module com.coderscratchpad.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;
    requires com.google.zxing;
    requires javafx.swing;
    requires javafx.web;
    requires java.prefs;

    opens com.coderscratchpad.javafxtutorial to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial;
}