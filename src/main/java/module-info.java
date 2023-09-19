module com.example.testfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.testfx to javafx.fxml;
    exports com.example.testfx;
}