module com.assignment1gc200489790 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    requires java.net.http;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;

    opens com.assignment1gc200489790 to javafx.fxml, com.google.gson;
    opens com.assignment1gc200489790.Controllers to javafx.fxml;
    opens com.assignment1gc200489790.Models to com.google.gson, com.fasterxml.jackson.databind, javafx.base;

    exports com.assignment1gc200489790;
}