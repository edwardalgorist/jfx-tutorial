module com.coderscratchpad.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.coderscratchpad.javafxtutorial to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial;
}