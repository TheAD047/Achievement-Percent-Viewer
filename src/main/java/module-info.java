module com.assignment1gc200489790 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.assignment1gc200489790 to javafx.fxml;
    exports com.assignment1gc200489790;
}