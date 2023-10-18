module com.coderscratchpad.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.coderscratchpad.javafxtutorial to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial;
}