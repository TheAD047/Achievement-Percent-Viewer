module com.assignment1gc200489790 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    requires java.net.http;

    opens com.assignment1gc200489790 to javafx.fxml, com.google.gson;
    exports com.assignment1gc200489790;
}