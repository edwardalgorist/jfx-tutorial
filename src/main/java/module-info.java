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
    exports com.coderscratchpad.javafxtutorial.label;
    opens com.coderscratchpad.javafxtutorial.label to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.checkbox;
    opens com.coderscratchpad.javafxtutorial.checkbox to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.images;
    opens com.coderscratchpad.javafxtutorial.images to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.webview;
    opens com.coderscratchpad.javafxtutorial.webview to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.charts;
    opens com.coderscratchpad.javafxtutorial.charts to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.progressbar;
    opens com.coderscratchpad.javafxtutorial.progressbar to javafx.fxml;
}